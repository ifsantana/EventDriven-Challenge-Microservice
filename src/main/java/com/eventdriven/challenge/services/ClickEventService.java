package com.eventdriven.challenge.services;

import com.eventdriven.challenge.domain.entities.Event;
import com.eventdriven.challenge.repositories.queries.EventCacheRepository;
import com.eventdriven.challenge.services.queries.ClickConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ClickEventService {
    private static final String TOPIC = "save_click_topic";
    private EventCacheRepository repository;
    private KafkaTemplate<String, Object> kafkaTemplate;
    private ClickConsumer consumer;

    @Autowired
    public ClickEventService(EventCacheRepository repository, KafkaTemplate<String, Object> kafkaTemplate, ClickConsumer consumer) {
        this.repository = repository;
        this.kafkaTemplate = kafkaTemplate;
        this.consumer = consumer;
    }

    public Iterable<Event> getAll() {

        return this.repository.findAll();
    }

    public void verifyClickLimit() {

    }
}
