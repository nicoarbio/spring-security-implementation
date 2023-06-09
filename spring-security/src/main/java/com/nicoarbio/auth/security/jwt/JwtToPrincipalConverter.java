package com.nicoarbio.auth.security.jwt;

import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.nicoarbio.auth.security.config.UserPrincipal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class JwtToPrincipalConverter {

    public UserPrincipal convert(DecodedJWT jwt) {
        return UserPrincipal.builder()
                .userId(jwt.getSubject())
                .email(jwt.getClaim("e").asString())
                .authorities(extractAuthoritiesFromClaim(jwt))
                .build();
    }

    private List<SimpleGrantedAuthority> extractAuthoritiesFromClaim(DecodedJWT jwt) {
        Claim claim = jwt.getClaim("a");
        if(claim.isNull() || claim.isMissing()) return List.of();
        return claim.asList(SimpleGrantedAuthority.class);
    }

}
