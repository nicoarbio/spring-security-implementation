package com.nicoarbio.auth.security.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RootController {

    @GetMapping("/")
    public ResponseEntity<String> rootMapping() {
        return ResponseEntity.ok ("{\"message\":\"HelloWorld!\"}");
    }

}
