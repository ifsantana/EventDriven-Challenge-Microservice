package com.eventdriven.challenge.services;

import com.eventdriven.challenge.domain.entities.Event;
import com.eventdriven.challenge.repositories.cache.EventRepository;
import com.eventdriven.challenge.services.component.ViewEventCacheWatcher;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ignite.Ignite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ViewEventService {
    private static final String TOPIC = "save_view_topic";
    private Ignite ignite;
    private EventRepository repository;
    private KafkaTemplate<String, Object> kafkaTemplate;
    private ObjectMapper objectMapper;
    private ViewEventCacheWatcher watcher;

    @Autowired
    public ViewEventService(Ignite ignite, EventRepository repository, KafkaTemplate<String, Object> kafkaTemplate, ObjectMapper objectMapper, ViewEventCacheWatcher watcher) {
        this.ignite = ignite;
        this.repository = repository;
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
        this.watcher = watcher;
    }

    public void test() {
        kafkaTemplate.send(TOPIC, new Event(1L));
    }

    public void registerViewEvent(Event event) {
        watcher.registerViewEventContinuousQuery();
    }
}
