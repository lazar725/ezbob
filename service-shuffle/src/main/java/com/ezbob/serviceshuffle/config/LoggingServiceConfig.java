package com.ezbob.serviceshuffle.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.stereotype.Service;

@ConfigurationProperties(prefix = "logging-service")
@ConfigurationPropertiesScan
@Service
public class LoggingServiceConfig {
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
