package com.nicoarbio.auth.config.security;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties("security.jwt")
public class JwtProperties {

    /**
     * Secret key used to sign the JWT.
     */
    private String secretKey;

    private long expireAfterHours;

    private String tokenPrefix;


}
