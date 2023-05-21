package com.nicoarbio.auth.security.service;

import com.nicoarbio.auth.security.jwt.JwtIssuer;
import com.nicoarbio.auth.security.config.UserPrincipal;
import com.nicoarbio.auth.security.model.LoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {


    private final JwtIssuer jwtIssuer;
    private final AuthenticationManager authenticationManager;

    public LoginResponse attemptLogin(String email, String password) {
        // Si el usuario ingresa mal el password, se lanza una excepcion
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password)
        );

        //Se configura el contexto de seguridad con el usuario autenticado
        SecurityContextHolder.getContext().setAuthentication(authentication);

        //Se obtiene el usuario autenticado
        UserPrincipal principal = (UserPrincipal) authentication.getPrincipal();

        //Se genera el token JWT
        String token = jwtIssuer.issue(
                principal.getUserId(),
                principal.getEmail(),
                principal.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList()
        );
        return LoginResponse.builder()
                .accessToken(token)
                .build();
    }

}
