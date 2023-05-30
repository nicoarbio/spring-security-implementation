package com.nicoarbio.auth.security.config;

import com.nicoarbio.auth.security.config.UserPrincipalAuthenticationToken;
import com.nicoarbio.auth.security.jwt.JwtDecoder;
import com.nicoarbio.auth.security.jwt.JwtProperties;
import com.nicoarbio.auth.security.jwt.JwtToPrincipalConverter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtProperties jwtProperties;

    private final JwtDecoder jwtDecoder;

    private final JwtToPrincipalConverter jwtToPrincipalConverter;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        extractTokenFromRequest(request) // returns string (jwt)
                .map(jwtDecoder::decode) //.map(jwt -> jwtDecoder.decode(jwt)) returns DecodedJWT (decodedJWT)
                .map(jwtToPrincipalConverter::convert) //.map(decodedJWT -> jwtToPrincipalConverter.convert(decodedJWT)) returns UserPrincipal (userPrincipal)
                .map(UserPrincipalAuthenticationToken::new) //.map(userPrincipal -> new UserPrincipalAuthenticationToken(userPrincipal)) returns UserPrincipalAuthenticationToken
                .ifPresent(authentication -> SecurityContextHolder.getContext().setAuthentication(authentication));
        filterChain.doFilter(request, response);
    }

    //               01234567->
    // Authorization: Bearer asdf.asdf.asdf
    private Optional<String> extractTokenFromRequest(HttpServletRequest request) {
        final String token = request.getHeader("Authorization");
        final String tokenPrefix = jwtProperties.getTokenPrefix().concat(" ");
        if (token != null && token.startsWith(tokenPrefix)) {
            return Optional.of(token.substring(tokenPrefix.length()));
        }
        return Optional.empty();
    }
}
