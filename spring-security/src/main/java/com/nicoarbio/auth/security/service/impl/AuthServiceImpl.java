package com.nicoarbio.auth.security.service.impl;

import com.nicoarbio.auth.security.jwt.JwtIssuer;
import com.nicoarbio.auth.security.config.UserPrincipal;
import com.nicoarbio.auth.security.dto.response.LoginResponse;
import com.nicoarbio.auth.security.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {


    private final JwtIssuer jwtIssuer;
    private final AuthenticationManager authenticationManager;

    public LoginResponse attemptEmailPasswordLogin(String email, String password) {
        // If users password is wrong, exception is thrown
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password)
        );

        // Security context is configured with authenticated user. User is now authenticated
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Get authenticated user
        UserPrincipal principal = (UserPrincipal) authentication.getPrincipal();

        // JWT generation
        String token = jwtIssuer.issue(
                principal.getUserId(),
                principal.getEmail(),
                principal.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList()
        );
        return LoginResponse.builder()
                .accessToken(token)
                .build();
    }

    public LoginResponse attemptGoogleLogin(String googleJWT) {
        return null;
    }



}
