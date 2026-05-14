package com.turkcell.spring_cqrs.core.security.context;

import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value="request", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class UserContext {
    private String userId;
    private String email;
    private List<String> roles = Collections.EMPTY_LIST;
    private boolean isAuthenticated = false;

    public void setUser(String userId, String email, List<String> roles) {
        this.isAuthenticated = true;
        this.userId = userId;
        this.roles = roles;
        this.email = email;
    }

    public String getUserId() {
        return userId;
    }
    public String getEmail() {
        return email;
    }
    public List<String> getRoles() {
        return roles;
    }
    public boolean isAuthenticated() {
        return isAuthenticated;
    }
    
    
}