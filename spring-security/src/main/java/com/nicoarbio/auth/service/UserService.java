package com.nicoarbio.auth.service;

import com.nicoarbio.auth.domain.UserEntity;
import com.nicoarbio.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Optional<UserEntity> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<UserEntity> findAll() {
        return (List<UserEntity>) userRepository.findAll();
    }



}
