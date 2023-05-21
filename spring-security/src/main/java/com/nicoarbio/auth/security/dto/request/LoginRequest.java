package com.nicoarbio.auth.security.dto.request;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LoginRequest {

    private String email;
    private String password;

}
