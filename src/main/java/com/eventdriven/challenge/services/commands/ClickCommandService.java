package com.eventdriven.challenge.services.commands;

import com.eventdriven.challenge.domain.entities.Event;
import com.eventdriven.challenge.repositories.commands.EventRepository;
import com.eventdriven.challenge.repositories.queries.EventCacheRepository;
import org.apache.ignite.IgniteCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClickCommandService {

    private EventRepository repository;
    private EventCacheRepository cacheRepository;

    @Autowired
    public ClickCommandService(EventRepository repository, EventCacheRepository cacheRepository) {
        this.repository = repository;
        this.cacheRepository = cacheRepository;
    }

    public void create(Event event) {
        this.cacheRepository.save(event.getId(), event);
        this.repository.save(event);
    }
}
