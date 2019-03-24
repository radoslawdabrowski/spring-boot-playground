package com.example.retryclient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Rest {
    private MyService myService;

    public Rest(MyService myService) {
        this.myService = myService;
    }

    @GetMapping
    public String pingOtherService(){
        return myService.simpleRetry();
    }
}
