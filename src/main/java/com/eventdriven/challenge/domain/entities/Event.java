package com.eventdriven.challenge.domain.entities;

import com.eventdriven.challenge.domain.enums.EventType;
import lombok.Data;
import org.apache.ignite.cache.query.annotations.QuerySqlField;

public @Data class Event {

    @QuerySqlField(index = true)
    private Long id;
    @QuerySqlField private
    EventType eventType;
    @QuerySqlField private
    String payload;

    public Event(Long id) {
        this.id = id;
    }
}
