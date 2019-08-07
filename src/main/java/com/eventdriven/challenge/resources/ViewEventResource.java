package com.eventdriven.challenge.resources;

import com.eventdriven.challenge.services.ViewEventService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/viewEvent")
public class ViewEventResource {

    private static final String BASE_PATH = "/api/v1/";
    private ViewEventService service;

    public ViewEventResource(ViewEventService service) {
        this.service = service;
    }
}
