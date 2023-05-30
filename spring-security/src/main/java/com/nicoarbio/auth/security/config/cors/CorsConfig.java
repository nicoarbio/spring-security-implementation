package com.nicoarbio.auth.security.config.cors;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

@Configuration
@Slf4j
public class CorsConfig {

    @Autowired
    CorsProperties corsProperties;

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                if (corsProperties.getOrigins() == null || corsProperties.getMethods() == null) {
                    log.error("CORS origins and/or methods are empty in application property file");
                } else {
                    registry.addMapping("/**")
                            .allowedOrigins(corsProperties.getOrigins())
                            .allowedMethods(corsProperties.getMethods());
                    log.info("CORS configured with origins: " + Arrays.toString(corsProperties.getOrigins()));
                    log.info("CORS configured with methods: " + Arrays.toString(corsProperties.getMethods()));
                }
            }
        };
    }

}
