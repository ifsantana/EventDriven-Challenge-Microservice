package com.eventdriven.challenge.services;

import com.eventdriven.challenge.repositories.cache.ViewEventRepository;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ViewEventService {
    private static final String TOPIC = "";
    private ViewEventRepository repository;
    private KafkaTemplate kafkaTemplate;

    public ViewEventService(ViewEventRepository repository, KafkaTemplate kafkaTemplate) {
        this.repository = repository;
        this.kafkaTemplate = kafkaTemplate;
    }
}
