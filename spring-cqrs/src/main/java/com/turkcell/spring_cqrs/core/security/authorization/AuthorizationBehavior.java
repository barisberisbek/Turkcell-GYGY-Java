package com.turkcell.spring_cqrs.core.security.authorization;

import java.util.Set;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.turkcell.spring_cqrs.core.exception.UnauthenticatedException;
import com.turkcell.spring_cqrs.core.exception.UnauthorizedException;
import com.turkcell.spring_cqrs.core.mediator.pipeline.PipelineBehavior;
import com.turkcell.spring_cqrs.core.mediator.pipeline.RequestHandlerDelegate;
import com.turkcell.spring_cqrs.core.security.context.UserContext;

/**
 * Pipeline'da Order(10) ile ilk çalışan behavior.
 * {@link AuthorizableRequest} ile işaretlenmiş Command/Query'ler için:
 * <ol>
 *   <li>Kimlik doğrulama kontrolü — başarısızsa {@link UnauthenticatedException} (401)</li>
 *   <li>Rol yetkilendirme kontrolü — başarısızsa {@link UnauthorizedException} (403)</li>
 * </ol>
 */
@Component
@Order(10)
public class AuthorizationBehavior implements PipelineBehavior {
    private final UserContext userContext;

    public AuthorizationBehavior(UserContext userContext) {
        this.userContext = userContext;
    }

    @Override
    public boolean supports(Object request) {
        return request instanceof AuthorizableRequest;
    }

    @Override
    public <R> R handle(Object request, RequestHandlerDelegate<R> next) {
        AuthorizableRequest authRequest = (AuthorizableRequest) request;

        // 1. Kimlik doğrulama kontrolü
        if (!userContext.isAuthenticated()) {
            throw new UnauthenticatedException();
        }

        // 2. Rol yetkilendirme kontrolü
        Set<String> requiredRoles = authRequest.getRequiredRoles();
        if (!requiredRoles.isEmpty()) {
            boolean hasRequiredRole = userContext.getRoles().stream()
                    .anyMatch(requiredRoles::contains);

            if (!hasRequiredRole) {
                throw new UnauthorizedException();
            }
        }

        return next.invoke();
    }

}
