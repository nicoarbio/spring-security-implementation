package com.nicoarbio.auth.security.controller;

import com.nicoarbio.auth.security.config.UserPrincipal;
import com.nicoarbio.auth.security.dto.request.GoogleLoginRequest;
import com.nicoarbio.auth.security.dto.request.LoginRequest;
import com.nicoarbio.auth.security.dto.response.GenericUserResponse;
import com.nicoarbio.auth.security.dto.response.LoginResponse;
import com.nicoarbio.auth.security.service.AuthService;
import com.nicoarbio.auth.security.service.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    private final UserService userService;

    private final ModelMapper modelMapper;

    @PostMapping("/auth/login")
    public ResponseEntity<LoginResponse> authLogin(@RequestBody @Validated LoginRequest request) {
        return new ResponseEntity<>(authService.attemptEmailPasswordLogin(request.getEmail(), request.getPassword()), HttpStatus.OK);
    }

    @PostMapping("/oauth2/google/login")
    public ResponseEntity<LoginResponse> oauth2GoogleLogin(@RequestBody @Validated GoogleLoginRequest request) {
        return new ResponseEntity<>(authService.attemptGoogleLogin(request.getJwtToken()), HttpStatus.OK);
    }

    // TODO: Review and delete these endpoints

    @GetMapping("/admin")
    @SecurityRequirement(name = "JWT_Bearer_required")
    public ResponseEntity<GenericUserResponse> admin(@AuthenticationPrincipal UserPrincipal principal) {
        return new ResponseEntity<>(userService.getByPrincipal(principal), HttpStatus.OK);
    }

    @GetMapping("/secured")
    @SecurityRequirement(name = "JWT_Bearer_required")
    public ResponseEntity<GenericUserResponse> secured(@AuthenticationPrincipal UserPrincipal principal) {
        return new ResponseEntity<>(userService.getByPrincipal(principal), HttpStatus.OK);
    }

}