package com.ezbob.servicelog.exceptions;

public class CustomExceptionResponse {
    private String message;
    private long timestamp;

    public CustomExceptionResponse(String message, long timestamp) {
        this.message = message;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public long getTimestamp() {
        return timestamp;
    }
}

