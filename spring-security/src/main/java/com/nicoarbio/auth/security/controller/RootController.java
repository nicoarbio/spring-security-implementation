package com.nicoarbio.auth.security.controller;

import com.nicoarbio.auth.security.dto.response.MessageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RootController {

    @GetMapping("/")
    public ResponseEntity<MessageResponse> rootMapping() {
        return new ResponseEntity<>(MessageResponse.builder().message("HelloWorld!").build(), HttpStatus.OK);
    }

}
