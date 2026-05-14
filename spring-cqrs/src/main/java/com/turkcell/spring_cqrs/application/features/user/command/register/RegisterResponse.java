package com.turkcell.spring_cqrs.application.features.user.command.register;

import java.util.UUID;

public record RegisterResponse(UUID id, String email) {}