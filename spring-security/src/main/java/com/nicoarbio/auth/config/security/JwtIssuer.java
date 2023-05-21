package com.nicoarbio.auth.config.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Component
@RequiredArgsConstructor
public class JwtIssuer {

    private final JwtProperties jwtProperties;

    public String issue(long userId, String userEmail, List<String> roles) {
        return JWT.create()
                .withSubject(String.valueOf(userId))
                .withExpiresAt(Instant.now().plus(Duration.of(jwtProperties.getExpireAfterHours(), ChronoUnit.HOURS)))
                .withClaim("e", userEmail) //e -> email
                .withClaim("a", roles) //a -> authorities
                .sign(Algorithm.HMAC256(jwtProperties.getSecretKey()));
    }

}
