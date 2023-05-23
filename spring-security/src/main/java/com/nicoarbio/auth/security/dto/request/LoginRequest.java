package com.nicoarbio.auth.security.dto.request;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Builder
public class LoginRequest {

    @NotBlank
    @Schema(example = "test@test.com")
    private final String email;

    @NotBlank
    @Schema(example = "123456")
    private final String password;

}
