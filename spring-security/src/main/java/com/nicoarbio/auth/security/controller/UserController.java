package com.nicoarbio.auth.security.controller;

import com.nicoarbio.auth.security.dto.response.GenericUserResponse;
import com.nicoarbio.auth.security.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @GetMapping("/all-users")
    public ResponseEntity<List<GenericUserResponse>> all_users() {
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

}
