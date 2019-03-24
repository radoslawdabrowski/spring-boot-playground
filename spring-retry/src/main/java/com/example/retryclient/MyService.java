package com.example.retryclient;

import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class MyService {

    @Retryable(maxAttempts = 10)
    public String simpleRetry() {
        log.info("calling external service");
        return (new RestTemplate()).getForObject("http://localhost:8080", String.class);
    }
}
