package com.nicoarbio.auth.security.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GoogleLoginRequest {

    @NotBlank
    private final String jwtToken;

}
