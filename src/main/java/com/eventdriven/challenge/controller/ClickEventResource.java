package com.eventdriven.challenge.controller;

import com.eventdriven.challenge.services.ClickEventService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
@Api(tags = "ClickEvent Resource", description = "ClickEvent Resource")
public class ClickEventResource {

    private static final String BASE_PATH = "/api/v1/";
    private ClickEventService service;

    @Autowired
    public ClickEventResource(ClickEventService service) {
        this.service = service;
    }

    @RequestMapping(value = BASE_PATH + "/click", method = GET)
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>("hello world", HttpStatus.OK);
    }
}
