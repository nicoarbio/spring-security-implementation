package com.nicoarbio.auth.security.controller;

import com.nicoarbio.auth.security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/all-users")
    public ResponseEntity<String> getAll() {
        return ResponseEntity.ok(userService.findAll().toString());
    }

}
