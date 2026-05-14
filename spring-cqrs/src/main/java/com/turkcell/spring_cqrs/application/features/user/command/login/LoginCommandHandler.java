package com.turkcell.spring_cqrs.application.features.user.command.login;

import java.util.Collections;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.turkcell.spring_cqrs.core.mediator.cqrs.CommandHandler;
import com.turkcell.spring_cqrs.core.security.jwt.JwtService;
import com.turkcell.spring_cqrs.domain.User;
import com.turkcell.spring_cqrs.persistence.repository.UserRepository;

@Component
public class LoginCommandHandler implements CommandHandler<LoginCommand, LoginResponse> {
    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public LoginCommandHandler(JwtService jwtService, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.jwtService = jwtService;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public LoginResponse handle(LoginCommand command) {
        // Todo: move to business rules
        User user = userRepository.findByEmail(command.email())
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));
        // Todo: move to business rules
        if (!passwordEncoder.matches(command.password(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        // User entity'sinde henüz rol alanı olmadığından boş liste geçiliyor.
        // İleride user.getRoles() ile değiştirilecek.
        String jwt = jwtService.generate(user.getId(), user.getEmail(), Collections.emptyList());
        return new LoginResponse(jwt);
    }
}