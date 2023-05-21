package com.nicoarbio.auth.security.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GenericUserResponse {

    private Long userId;
    private String email;
    private String authorities;
    private String message;

}
