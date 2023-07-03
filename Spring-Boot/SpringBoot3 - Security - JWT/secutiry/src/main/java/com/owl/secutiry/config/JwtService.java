package com.owl.secutiry.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.io.InputStream;
import java.security.*;
import java.security.cert.CertificateException;
import java.util.function.Function;

@Service
public class JwtService {

   private KeyStore keyStore;
   @Value("${jks.pass}")
   private String jksPass;

   @PostConstruct
   public void init() {
       try {
           this.keyStore = KeyStore.getInstance("JKS");
           InputStream resourceAsStream = getClass().getResourceAsStream("/owl.jks");
           this.keyStore.load(resourceAsStream, this.jksPass.toCharArray());
       } catch (KeyStoreException | IOException | NoSuchAlgorithmException | CertificateException e) {
           throw new RuntimeException(e);
       }
   }

    public String extractUserName(String token) {
        return null;
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
       final Claims claims = extractAllClaims(token);
       return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJwt(token)
                .getBody();
    }

    private Key getSignInKey() {
        try {
            return this.keyStore.getKey("owl", this.jksPass.toCharArray());
        } catch (KeyStoreException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (UnrecoverableKeyException e) {
            throw new RuntimeException(e);
        }
    }

}
