package com.quintrix.jfs.quintrixspring.config;

import java.time.Duration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfig {


  // created value for time in application.yml
  @Value("${timeout.duration}")
  Long timeoutDuration;

  @Bean
  public RestTemplate restTemplate(RestTemplateBuilder builder) {
    return builder.setConnectTimeout(Duration.ofMillis(timeoutDuration))
        .setReadTimeout(Duration.ofMillis(timeoutDuration)).build();
  }

}

