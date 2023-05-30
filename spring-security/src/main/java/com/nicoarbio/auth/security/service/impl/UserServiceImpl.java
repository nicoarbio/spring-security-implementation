package com.nicoarbio.auth.security.service.impl;

import com.nicoarbio.auth.security.config.UserPrincipal;
import com.nicoarbio.auth.security.domain.UserEntity;
import com.nicoarbio.auth.security.dto.response.GenericUserResponse;
import com.nicoarbio.auth.security.repository.UserRepository;
import com.nicoarbio.auth.security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

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
