package com.turkcell.spring_cqrs.application.features.category.query.getall;

import java.util.Set;

import org.springframework.data.domain.Page;

import com.turkcell.spring_cqrs.core.mediator.cqrs.Query;
import com.turkcell.spring_cqrs.core.security.authorization.AuthorizableRequest;

/**
 * Tüm kategorileri sayfalanmış olarak getiren query.
 * {@link AuthorizableRequest} implementasyonu sayesinde:
 * <ul>
 *   <li>Kimlik doğrulaması gerektirir (giriş yapılmış olmalı)</li>
 *   <li>"admin" rolü gerektirir</li>
 * </ul>
 */
public record GetAllCategoriesQuery(int pageNumber, int pageSize)
    implements Query<Page<GetAllCategoriesResponse>>, AuthorizableRequest {

    @Override
    public Set<String> getRequiredRoles() {
        return Set.of("admin");
    }
}