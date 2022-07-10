package com.ezbob.serviceshuffle.controllers;

import com.ezbob.serviceshuffle.exceptions.InvalidArrayLengthException;
import com.ezbob.serviceshuffle.models.ShuffledArrayResponse;
import com.ezbob.serviceshuffle.services.LoggingService;
import com.ezbob.serviceshuffle.services.ShufflingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class ShuffleController {
    private final ShufflingService shufflingService;
    private final LoggingService loggingService;

    public ShuffleController(
            ShufflingService shufflingService,
            LoggingService loggingService) {
        this.shufflingService = shufflingService;
        this.loggingService = loggingService;
    }

    @GetMapping("/shuffle/{arrayLength}")
    public ResponseEntity<ShuffledArrayResponse> getShuffledArray(@PathVariable int arrayLength) throws ResponseStatusException {
        try {
            int[] shuffledArray = shufflingService.getShuffledArrayByLength(arrayLength);
            ShuffledArrayResponse response = new ShuffledArrayResponse(shuffledArray);

            loggingService.logObject(response);

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (InvalidArrayLengthException ex) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    ex.getMessage()
            );
        }
    }
}
