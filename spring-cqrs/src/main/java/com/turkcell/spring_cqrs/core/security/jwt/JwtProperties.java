package com.turkcell.spring_cqrs.core.security.jwt;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="security.jwt")
public class JwtProperties {
    private String secret;
    private long expirationInSeconds = 360000;
    private String issuer = "spring-cqrs";


    public String getSecret() {
        return secret;
    }
    public void setSecret(String secret) {
        this.secret = secret;
    }
    public long getExpirationInSeconds() {
        return expirationInSeconds;
    }
    public void setExpirationInSeconds(long expirationInSeconds) {
        this.expirationInSeconds = expirationInSeconds;
    }
    public String getIssuer() {
        return issuer;
    }
    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    
}
