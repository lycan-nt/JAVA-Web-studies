package com.owl.secutiry.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.io.InputStream;
import java.security.*;
import java.security.cert.CertificateException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

   private KeyStore keyStore;
   @Value("${jks.pass}")
   private String jksPass;
   @Value("${jwt.expiration}")
   private String EXPIRATION_TIME;

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
       return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
       final Claims claims = extractAllClaims(token);
       return claimsResolver.apply(claims);
    }

    public String generateToken(UserDetails userDetails) {
       return generateToken(new HashMap<>(), userDetails);
    }

    public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {
       return Jwts
               .builder()
               .setClaims(extraClaims)
               .setSubject(userDetails.getUsername())
               .setIssuedAt(new Date(System.currentTimeMillis()))
               .setExpiration(getTimeExpiration())
               .signWith(getSignInKey())
               .compact();
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
       final String userName = extractUserName(token);
       return (userName.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
       return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
       return extractClaim(token, Claims::getExpiration);
    }

    private Date getTimeExpiration() {
        return  Date.from(LocalDateTime.now()
                        .plusMinutes(Long.parseLong(this.EXPIRATION_TIME))
                        .atZone(ZoneId.systemDefault())
                        .toInstant());
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
