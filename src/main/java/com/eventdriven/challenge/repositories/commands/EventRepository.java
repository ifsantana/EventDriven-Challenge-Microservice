package com.eventdriven.challenge.repositories.commands;

import com.eventdriven.challenge.domain.entities.Event;
import org.springframework.stereotype.Repository;
import org.springframework.data.cassandra.repository.CassandraRepository;

@Repository
public interface EventRepository extends CassandraRepository<Event, Long> {
}
