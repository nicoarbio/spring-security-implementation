package com.nicoarbio.auth.security.config;

import com.nicoarbio.auth.security.domain.UserEntity;
import com.nicoarbio.auth.security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //We need a UserPrincipal and userService returns UserEntity
        UserEntity user = userService.getByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return UserPrincipal.builder()
                .userId(user.getId())
                .email(user.getEmail())
                .authorities(user.getRolesAsString().stream().map(SimpleGrantedAuthority::new).toList())
                .password(user.getPassword())
                .build();
    }

}
