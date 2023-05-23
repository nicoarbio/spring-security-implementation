package com.nicoarbio.auth.security.service;

import com.nicoarbio.auth.security.config.UserPrincipal;
import com.nicoarbio.auth.security.domain.UserEntity;
import com.nicoarbio.auth.security.dto.response.GenericUserResponse;
import com.nicoarbio.auth.security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

    public Optional<UserEntity> getByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<GenericUserResponse> getAll() {
        return userRepository.findAll().stream().map(
                user -> modelMapper.map(user, GenericUserResponse.class)
        ).toList();
    }

    public GenericUserResponse getByPrincipal(UserPrincipal principal) {
        UserEntity user = this.getByEmail(principal.getEmail()).orElseThrow();
        GenericUserResponse response = modelMapper.map(user, GenericUserResponse.class);
        return response;
    }





}
