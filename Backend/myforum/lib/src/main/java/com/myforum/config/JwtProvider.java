package com.myforum.config;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtProvider {

    private final String secretKey = "luksdbgkujyhfuo9q7oecny8wi7ebyfgi7ukyancu367ebrnf8i6icbyn3ia6buiy7obwep8fucpbeafg686838btfn2i6obn68bfyn2bewfo7";
    private final long validityInMilliseconds = 3600000; // 1 hour

    public String generateToken(String username) {
        Date now = new Date();
        Date validity = new Date(now.getTime() + validityInMilliseconds);

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public String extractUsername(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }
}
