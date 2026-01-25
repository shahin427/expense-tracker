package com.example.expensetracker.security;

import com.example.expensetracker.entities.UserEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class TokenUtils {
    private static final long expirationTime = 1000 * 60 * 60;

    private static Key key;
    @Value("${jwt.secret}")
    private String SECRET_KEY;

    @PostConstruct
    public void initialize() {
        key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    public static String generateToken(UserEntity user) {
        return Jwts.builder()
                .setSubject(user.getUsername())
                .claim("name", user.getName())
                .claim("familyName", user.getFamilyName())
                .claim("roles", user.getRoles().stream().map(role -> role.getTitle()).toList())
                .setIssuedAt(new Date())
                .signWith(key)
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .compact();
    }

    public static String tokenValidation(String token) {

        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            return claims.getSubject();
        } catch (ExpiredJwtException e) {
            throw new RuntimeException("Token is Expired");
        } catch (JwtException e) {
            throw new RuntimeException("Invalid Token");
        }
    }
}
