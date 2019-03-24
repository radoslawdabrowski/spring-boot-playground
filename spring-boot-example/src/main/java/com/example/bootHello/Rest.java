package com.example.bootHello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Rest {

    @GetMapping("/ping")
    public String ping(){
        return "pong";
    }
}
