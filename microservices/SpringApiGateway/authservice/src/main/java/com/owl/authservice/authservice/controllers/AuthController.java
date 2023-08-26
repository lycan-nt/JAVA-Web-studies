package com.owl.authservice.authservice.controllers;

import com.owl.authservice.authservice.dtos.AuthRequest;
import com.owl.authservice.authservice.entities.UserCredential;
import com.owl.authservice.authservice.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private AuthService authService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public String registerUser(
            @RequestBody UserCredential userCredential
    ) {
        return this.authService.saveUser(userCredential);
    }

    @PostMapping("/token")
    public String getToken(
            @RequestBody AuthRequest authRequest
    ) {
        Authentication authentication = this.authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            String token = this.authService.generateToken(authRequest.getUsername());
            System.out.println("TOKEN: " + token);
            return token;
        }
        else {
            throw new RuntimeException("Invalid Access");
        }
    }

    @GetMapping("/valid")
    public String validateToken(
            @RequestParam("Token") String token
    ) {
        this.authService.validateToken(token);
        return "Token is valid";
    }
}
