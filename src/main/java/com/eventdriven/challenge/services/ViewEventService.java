package com.eventdriven.challenge.services;

import com.eventdriven.challenge.repositories.cache.ViewEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ViewEventService {
    private static final String TOPIC = "";
    private ViewEventRepository repository;
//    private KafkaTemplate kafkaTemplate;

    @Autowired
    public ViewEventService(ViewEventRepository repository) {
        this.repository = repository;
    }
}
