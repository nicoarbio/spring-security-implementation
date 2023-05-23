package com.nicoarbio.auth.security.dto.response;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {

    @Schema(description = "JWT token", example = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxIiwiYSI6WyJST0xFX0FETUlOIl0sImUiOiJ0ZXN0QHRlc3QuY29tIiwiZXhwIjoxNjg0NzcxMDUxfQ.WJF8-wII_ZrXIeqNLEzQxABaD-5bDheWd6UDpDUjhQM")
    private String accessToken;

}
