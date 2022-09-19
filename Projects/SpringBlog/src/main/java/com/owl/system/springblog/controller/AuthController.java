package com.owl.system.springblog.controller;

import com.owl.system.springblog.dto.RegisterRequest;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @PostMapping("/signup")
    public void signUp(RegisterRequest registerRequest) {

    }

}
