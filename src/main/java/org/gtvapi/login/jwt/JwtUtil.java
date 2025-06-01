package org.gtvapi.login.jwt;

import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import org.gtvapi.conf.ApplicationProperties;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class JwtUtil {

    private final ApplicationProperties applicationProperties;

    public String generateToken(Map<String, Object> claims, String username) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + applicationProperties.getExpirationTime()))
                .signWith(SignatureAlgorithm.HS512, applicationProperties.getSecret())
                .compact();
    }

    public String extractUsername(String token) {
        return Jwts.parser().setSigningKey(applicationProperties.getSecret()).parseClaimsJws(token).getBody().getSubject();
    }

    public Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(applicationProperties.getSecret()).parseClaimsJws(token).getBody();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(applicationProperties.getSecret()).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

