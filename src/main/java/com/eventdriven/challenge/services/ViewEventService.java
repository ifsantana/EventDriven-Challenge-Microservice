package com.eventdriven.challenge.services;

import com.eventdriven.challenge.domain.ClickEvent;
import com.eventdriven.challenge.repositories.cache.ViewEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ViewEventService {
    private static final String TOPIC = "save_view_topic";
    private ViewEventRepository repository;
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Autowired
    public ViewEventService(ViewEventRepository repository, KafkaTemplate<String, Object> kafkaTemplate) {
        this.repository = repository;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void test() {
        kafkaTemplate.send(TOPIC, new ClickEvent(1L));
    }
}
