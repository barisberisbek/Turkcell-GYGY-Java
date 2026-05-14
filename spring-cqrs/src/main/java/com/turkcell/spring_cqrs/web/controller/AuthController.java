package com.turkcell.spring_cqrs.web.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.spring_cqrs.application.features.user.command.login.LoginCommand;
import com.turkcell.spring_cqrs.application.features.user.command.login.LoginResponse;
import com.turkcell.spring_cqrs.application.features.user.command.register.RegisterCommand;
import com.turkcell.spring_cqrs.application.features.user.command.register.RegisterResponse;
import com.turkcell.spring_cqrs.core.mediator.Mediator;

import jakarta.validation.Valid;

@RequestMapping("/api/auth")
@RestController
public class AuthController {

    private final Mediator mediator;

    public AuthController(Mediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping("register")
    public RegisterResponse register(@RequestBody @Valid RegisterCommand command)
    {
        return mediator.send(command);
    }
    @PostMapping("login")
    public LoginResponse login(@RequestBody @Valid LoginCommand command)
    {
        return mediator.send(command);
    }
}
