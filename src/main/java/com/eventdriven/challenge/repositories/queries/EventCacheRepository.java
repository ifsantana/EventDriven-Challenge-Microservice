package com.eventdriven.challenge.repositories.queries;

import com.eventdriven.challenge.domain.entities.Event;
import org.apache.ignite.springdata20.repository.IgniteRepository;
import org.apache.ignite.springdata20.repository.config.RepositoryConfig;

@RepositoryConfig(cacheName = "EventCache")
public interface EventCacheRepository extends IgniteRepository<Event, Long> {
}
