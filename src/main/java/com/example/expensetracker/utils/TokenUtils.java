package com.example.expensetracker.utils;

import com.example.expensetracker.entities.UserEntity;
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
                .claim("name",user.getName())
                .claim("familyName",user.getFamilyName())
                .setIssuedAt(new Date())
                .signWith(key)
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .compact();
    }
}
