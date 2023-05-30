package com.nicoarbio.auth.security.service;

import com.nicoarbio.auth.security.dto.response.LoginResponse;

public interface AuthService {

    public LoginResponse attemptEmailPasswordLogin(String email, String password);
    public LoginResponse attemptGoogleLogin(String googleJWT);

}
