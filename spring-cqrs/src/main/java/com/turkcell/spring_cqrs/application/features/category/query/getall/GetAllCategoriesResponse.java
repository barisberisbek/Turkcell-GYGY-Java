package com.turkcell.spring_cqrs.application.features.category.query.getall;

import java.util.UUID;

public record GetAllCategoriesResponse(UUID id, String name) {}
