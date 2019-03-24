package com.example.springbootadminclient;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class Rest {

    @GetMapping
    public String ping(){
        log.info("user is pinging");
        return "pong";
    }
}
