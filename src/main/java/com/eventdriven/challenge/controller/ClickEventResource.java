package com.eventdriven.challenge.controller;

import com.eventdriven.challenge.domain.entities.Event;
import com.eventdriven.challenge.domain.enums.EventType;
import com.eventdriven.challenge.services.ClickEventService;
import com.eventdriven.challenge.services.commands.ClickCommandService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
@Api(tags = "ClickEvent Resource", description = "ClickEvent Resource")
public class ClickEventResource {

    private static final String BASE_PATH = "/api/v1/";
    private ClickEventService service;
    private ClickCommandService commandService;

    @Autowired
    public ClickEventResource(ClickEventService service, ClickCommandService commandService) {
        this.service = service;
        this.commandService = commandService;
    }

    @RequestMapping(value = BASE_PATH + "/click", method = GET)
    public ResponseEntity<Iterable<Event>> getAll() {
        return new ResponseEntity<Iterable<Event>>(this.service.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = BASE_PATH + "/click", method = POST)
    public ResponseEntity<?> create(@RequestBody Event event) {
        this.commandService.create(new Event(2L, EventType.CLICK, "blabla@gmail.com", "testando", new Date()));
        return new ResponseEntity<>("hello world", HttpStatus.OK);
    }
}
