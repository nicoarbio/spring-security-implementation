package com.nicoarbio.auth.security.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
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
