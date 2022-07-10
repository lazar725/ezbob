package com.ezbob.servicelog.controllers;

import com.ezbob.servicelog.services.Logger;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class LoggingController {
    private final Logger logger;

    public LoggingController(Logger logger) {
        this.logger = logger;
    }

    @PostMapping("/log")
    public ResponseEntity<Void> logObject(@RequestBody Object object) {
        try {
            logger.logToConsole(object);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (JsonProcessingException ex) {
            System.out.println(ex.getMessage());

            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Failed to log object"
                    );
        }
    }
}
