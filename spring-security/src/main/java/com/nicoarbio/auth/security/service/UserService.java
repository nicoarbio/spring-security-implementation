package com.nicoarbio.auth.security.service;

import com.nicoarbio.auth.security.config.UserPrincipal;
import com.nicoarbio.auth.security.domain.UserEntity;
import com.nicoarbio.auth.security.dto.response.GenericUserResponse;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public Optional<UserEntity> getByEmail(String email);
    public List<GenericUserResponse> getAll();
    public GenericUserResponse getByPrincipal(UserPrincipal principal);

}