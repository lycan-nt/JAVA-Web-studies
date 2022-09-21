package com.owl.system.springblog.security;

import com.owl.system.springblog.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.security.Key;

@Service
public class JwtProvider {

    private Key key;

    @PostConstruct
    public void init() {
        key = Keys.secretKeyFor(SignatureAlgorithm.ES512);
    }

    public String generateToken(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        return Jwts.builder()
                .setSubject(user.getUserName())
                .signWith(key)
                .compact();
    }

}
