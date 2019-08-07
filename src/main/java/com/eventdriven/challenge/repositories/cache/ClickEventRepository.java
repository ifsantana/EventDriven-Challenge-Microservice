package com.eventdriven.challenge.repositories.cache;

import com.eventdriven.challenge.domain.ClickEvent;
import org.apache.ignite.springdata20.repository.IgniteRepository;
import org.apache.ignite.springdata20.repository.config.RepositoryConfig;

@RepositoryConfig(cacheName = "ClickEventCache")
public interface ClickEventRepository extends IgniteRepository<ClickEvent, Long> {

}
