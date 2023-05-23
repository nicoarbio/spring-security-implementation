package com.nicoarbio.auth.modelmapper;

import com.nicoarbio.auth.security.domain.UserEntity;
import com.nicoarbio.auth.security.dto.response.GenericUserResponse;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();

        // Mapping: UserEntity to GenericUserResponse
        modelMapper.typeMap(UserEntity.class, GenericUserResponse.class).addMappings(mapper -> {
            mapper.map(UserEntity::getRoles, GenericUserResponse::setAuthorities);
        });


        return modelMapper;
    }

}
