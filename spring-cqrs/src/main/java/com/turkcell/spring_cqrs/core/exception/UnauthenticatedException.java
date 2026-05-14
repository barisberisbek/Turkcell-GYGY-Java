package com.turkcell.spring_cqrs.core.exception;

/**
 * Kimlik doğrulaması yapılmamış isteklerde fırlatılır.
 * GlobalExceptionHandler tarafından HTTP 401 (Unauthorized) olarak döndürülür.
 */
public class UnauthenticatedException extends RuntimeException {

    public UnauthenticatedException() {
        super("Kimlik doğrulaması gerekli. Lütfen giriş yapın.");
    }

    public UnauthenticatedException(String message) {
        super(message);
    }
}
