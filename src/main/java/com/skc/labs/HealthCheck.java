package com.skc.labs;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheck {


    @GetMapping("/health")
    public String sayHello(){
        return "I am alive";
    }



}
