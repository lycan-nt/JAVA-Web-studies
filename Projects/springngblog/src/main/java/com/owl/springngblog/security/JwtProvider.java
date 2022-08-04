package com.owl.springngblog.security;

import com.owl.springngblog.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.PublicKey;

@Service
public class JwtProvider {

    private Key key;
    private KeyStore keyStore;

    @PostConstruct
    public void init() {
        key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    }

    public String generateToken(Authentication authentication) {
        User principal = (User) authentication.getPrincipal();
        return Jwts.builder()
                .setSubject(principal.getUserName())
                .signWith(key)
                .compact();
    }

    public boolean validateToken(String jwt) throws Exception {
        Jwts.parser().setSigningKey(getPublickey()).parseClaimsJws(jwt);
        return true;
    }

    private PublicKey getPublickey() throws Exception {
        try {
            return keyStore.getCertificate("springblog").getPublicKey();
        } catch (KeyStoreException e) {
            throw new Exception("Exception occured while retrieving public key from keystore");
        }
    }

    public String getUsernameFromJWT(String token) throws Exception {
        Claims claims = Jwts.parser()
                .setSigningKey(getPublickey())
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

}
