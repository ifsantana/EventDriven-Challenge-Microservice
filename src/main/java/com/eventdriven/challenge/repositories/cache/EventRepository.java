package com.eventdriven.challenge.repositories.cache;

import com.eventdriven.challenge.domain.entities.Event;
import org.apache.ignite.springdata20.repository.IgniteRepository;
import org.apache.ignite.springdata20.repository.config.RepositoryConfig;

@RepositoryConfig(cacheName = "EventCache")
public interface EventRepository extends IgniteRepository<Event, Long> {
}
