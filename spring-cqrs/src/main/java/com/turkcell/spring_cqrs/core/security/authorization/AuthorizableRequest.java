package com.turkcell.spring_cqrs.core.security.authorization;

import java.util.Collections;
import java.util.Set;

/**
 * Bu interface'i implemente eden Command/Query'ler pipeline'daki
 * {@link AuthorizationBehavior} tarafından yetkilendirme kontrolüne tabi tutulur.
 *
 * <p>{@link #getRequiredRoles()} varsayılan olarak boş set döner;
 * bu durumda sadece kimlik doğrulama (authentication) yeterlidir.
 * Override edilerek belirli roller istenebilir.</p>
 */
public interface AuthorizableRequest {

    /**
     * Bu isteğin gerektirdiği rolleri döner.
     * Boş set → sadece kimlik doğrulama yeterli, rol kontrolü yapılmaz.
     * Dolu set → kullanıcının en az bir gerekli role sahip olması beklenir.
     *
     * @return gerekli roller
     */
    default Set<String> getRequiredRoles() {
        return Collections.emptySet();
    }
}
