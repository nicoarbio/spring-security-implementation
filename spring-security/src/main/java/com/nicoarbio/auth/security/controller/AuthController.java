package com.nicoarbio.auth.security.controller;

import com.nicoarbio.auth.security.config.UserPrincipal;
import com.nicoarbio.auth.security.dto.request.LoginRequest;
import com.nicoarbio.auth.security.dto.response.GenericUserResponse;
import com.nicoarbio.auth.security.dto.response.LoginResponse;
import com.nicoarbio.auth.security.service.AuthService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/auth/login")
    public ResponseEntity<LoginResponse> authLogin(@RequestBody @Validated LoginRequest request) {
        return ResponseEntity.ok(authService.attemptLogin(request.getEmail(), request.getPassword()));
    }

    // TODO: Review and delete these endpoints

    @GetMapping("/admin")
    @SecurityRequirement(name = "JWT_Bearer_required")
    public ResponseEntity<GenericUserResponse> admin(@AuthenticationPrincipal UserPrincipal principal) {
        return ResponseEntity.ok(GenericUserResponse.builder()
                .message("Hello ADMIN!")
                .userId(principal.getUserId())
                .email(principal.getEmail())
                .authorities(Arrays.toString(principal.getAuthorities().toArray()))
                .build());
    }

    @GetMapping("/secured")
    @SecurityRequirement(name = "JWT_Bearer_required")
    public ResponseEntity<GenericUserResponse> secured(@AuthenticationPrincipal UserPrincipal principal) {
        return ResponseEntity.ok(GenericUserResponse.builder()
                .message("Hello Secured-with-password World!")
                .userId(principal.getUserId())
                .email(principal.getEmail())
                .authorities(Arrays.toString(principal.getAuthorities().toArray()))
                .build());
    }

}