package com.owl.authservice.authservice.services;

import com.owl.authservice.authservice.entities.UserCredential;
import com.owl.authservice.authservice.repositories.UserCredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserCredentialRepository credentialRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtService jwtService;

    public String saveUser(UserCredential credential) {
        credential.setPassword(this.passwordEncoder.encode(credential.getPassword()));
        this.credentialRepository.save(credential);
        return "User added to the system";
    }

    public String generateToken(String username) {
        return this.jwtService.generateToken(username);
    }

    public void validateToken(String token) {
        this.jwtService.validateToken(token);
    }

}
