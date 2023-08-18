package com.owl.service2.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/services")
public class Service2Controller {

    @GetMapping("/say")
    public String hello() {
        return "Hello Service 2";
    }

}
