package com.ezbob.serviceshuffle.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<CustomExceptionResponse> handleResponseStatusException(
            ResponseStatusException ex) {

        CustomExceptionResponse customExceptionResponse =
                new CustomExceptionResponse(ex.getReason(), System.currentTimeMillis());

        return new ResponseEntity<>(customExceptionResponse, ex.getStatus());
    }
}
