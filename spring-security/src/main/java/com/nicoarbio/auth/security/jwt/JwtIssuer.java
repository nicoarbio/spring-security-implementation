package com.nicoarbio.auth.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.nicoarbio.auth.security.properties.JwtProperties;
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

    public String issue(String userId, String userEmail, List<String> roles) {
        return JWT.create()
                .withSubject(userId)
                .withExpiresAt(Instant.now().plus(Duration.of(jwtProperties.getExpireAfterHours(), ChronoUnit.HOURS)))
                .withClaim("e", userEmail) //e -> email
                .withClaim("a", roles) //a -> authorities
                .sign(Algorithm.HMAC256(jwtProperties.getSecretKey()));
    }

}
