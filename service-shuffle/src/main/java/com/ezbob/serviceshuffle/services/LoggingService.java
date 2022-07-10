package com.ezbob.serviceshuffle.services;

import com.ezbob.serviceshuffle.config.LoggingServiceConfig;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


@Service
public class LoggingService {
    private final LoggingServiceConfig loggingServiceConfig;
    private final WebClient webClient;

    public LoggingService(LoggingServiceConfig loggingServiceConfig) {
        this.loggingServiceConfig = loggingServiceConfig;
        this.webClient = WebClient.create(loggingServiceConfig.getUrl());
    }

    public void logObject(Object object) {
        webClient.post()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(Mono.just(object), Object.class)
                .retrieve()
                .bodyToMono(Object.class)
                .subscribe();
    }
}
