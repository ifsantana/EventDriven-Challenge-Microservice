package com.eventdriven.challenge.domain;

import lombok.Data;
import org.apache.ignite.cache.query.annotations.QuerySqlField;
import java.io.Serializable;

public @Data class ClickEvent implements Serializable {

    @QuerySqlField(index = true)
    private Long id;
}
