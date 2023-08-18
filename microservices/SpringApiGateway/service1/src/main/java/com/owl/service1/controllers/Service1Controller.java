package com.owl.service1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/services")
public class Service1Controller {

    @GetMapping("/say")
    public String hello() {
        return "Hello Service 1";
    }

}
