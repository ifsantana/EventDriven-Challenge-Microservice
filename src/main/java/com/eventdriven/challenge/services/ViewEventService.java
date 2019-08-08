package com.eventdriven.challenge.services;

import com.eventdriven.challenge.domain.ClickEvent;
import com.eventdriven.challenge.domain.ViewEvent;
import com.eventdriven.challenge.repositories.cache.ViewEventRepository;
import com.eventdriven.challenge.services.component.ViewEventCacheWatcher;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.cache.query.ContinuousQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
@Service
public class ViewEventService {
    private static final String TOPIC = "save_view_topic";
    private Ignite ignite;
    private ViewEventRepository repository;
    private KafkaTemplate<String, Object> kafkaTemplate;
    private ObjectMapper objectMapper;
    private ViewEventCacheWatcher watcher;

    @Autowired
    public ViewEventService(Ignite ignite, ViewEventRepository repository, KafkaTemplate<String, Object> kafkaTemplate, ObjectMapper objectMapper, ViewEventCacheWatcher watcher) {
        this.ignite = ignite;
        this.repository = repository;
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
        this.watcher = watcher;
    }

    public void test() {
        kafkaTemplate.send(TOPIC, new ClickEvent(1L));
    }

    public void registerViewEvent(ViewEvent event) {
        watcher.registerViewEventContinuosQuery();
    }
}
