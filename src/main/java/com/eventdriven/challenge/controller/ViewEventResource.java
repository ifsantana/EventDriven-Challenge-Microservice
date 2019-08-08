package com.eventdriven.challenge.controller;

import com.eventdriven.challenge.services.ViewEventService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
@Api(tags = "ViewEvent Resource", description = "ViewEvent Resource")
public class ViewEventResource {

    private static final String BASE_PATH = "/api/v1/";
    private ViewEventService service;

    @Autowired
    public ViewEventResource(ViewEventService service) {
        this.service = service;
    }

    @RequestMapping(value = BASE_PATH + "/view", method = GET)
    public ResponseEntity<?> getAll() {
        this.service.test();
        return new ResponseEntity<>("message has been send!", HttpStatus.OK);
    }
}
