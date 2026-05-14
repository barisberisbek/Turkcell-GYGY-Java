package com.turkcell.spring_starter.dto;

import java.util.UUID;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateProductRequest(
    @NotBlank
    @Length(min=3, max=100)
    String name,
    String description,
    @NotNull
    UUID categoryId
) {
}
