package com.example.expensetracker.security;

import com.example.expensetracker.entities.UserEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class TokenUtils {

    static long expirationTime = 1000 * 60 * 10; // 10 minutes
    private static final String SECRET_KEY = "mySecretKey1fdsafasfasdfasdfdsafgwert34tg3w4ty3y35yt32345";
    private static final Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

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
            throw new RuntimeException("Token is expired");
        } catch (JwtException e) {
            throw new RuntimeException("Invalid token");
        }
    }
}
