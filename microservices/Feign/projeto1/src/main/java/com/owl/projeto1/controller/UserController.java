package com.owl.projeto1.controller;

import com.owl.projeto1.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @GetMapping
    public User getUser() {
        return User.builder()
                .name("Felipe")
                .email("felipe@developer.com")
                .idade(27)
                .build();
    }

}
