package com.nicoarbio.auth.security.dto.response;

import com.nicoarbio.auth.security.domain.Role;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GenericUserResponse {

    @Schema(example = "6300efed-959c-42fb-9fbc-4955a44767fe")
    private String userId;

    @Schema(example = "test@test.com")
    private String email;

    @Schema(example = "[ROLE_ADMIN]")
    private Collection<Role> authorities;

}
