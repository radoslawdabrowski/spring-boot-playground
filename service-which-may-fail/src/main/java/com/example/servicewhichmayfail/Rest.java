package com.example.servicewhichmayfail;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Rest {

    @GetMapping
    public String ping(){
        return "pong";
    }
}
