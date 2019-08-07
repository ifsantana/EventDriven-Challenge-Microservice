package com.eventdriven.challenge.repositories.cache;

import com.eventdriven.challenge.domain.ViewEvent;
import org.apache.ignite.springdata20.repository.IgniteRepository;
import org.apache.ignite.springdata20.repository.config.RepositoryConfig;

@RepositoryConfig(cacheName = "ViewEventCache")
public interface ViewEventRepository extends IgniteRepository<ViewEvent, Long> {

}
