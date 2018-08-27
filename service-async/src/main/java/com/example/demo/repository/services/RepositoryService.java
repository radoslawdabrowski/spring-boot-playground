package com.example.demo.repository.services;

import com.example.demo.repository.dto.RepositoryDto;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
public class RepositoryService {
    private final RestTemplate restTemplate;

    public RepositoryService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.errorHandler(new DefaultResponseErrorHandler()).build();
    }

    @Async
    public CompletableFuture<RepositoryDto> findRepository(String url) {
        log.info(String.format("Looking up %s", url));
        RepositoryDto repositoryDto = restTemplate.getForObject(url, RepositoryDto.class);
        return CompletableFuture.completedFuture(repositoryDto);
    }
}