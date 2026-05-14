package com.turkcell.spring_cqrs.application.features.user.rule;

import org.springframework.stereotype.Component;

@Component
public class UserBusinessRules {
    public void userWithSameEmailMustNotExist(String email)
    {
        //...
    }
}
