package com.turkcell.spring_cqrs.core.exception;

/**
 * Giriş yapılmış ancak yetkisi yetersiz olan isteklerde fırlatılır.
 * GlobalExceptionHandler tarafından HTTP 403 (Forbidden) olarak döndürülür.
 */
public class UnauthorizedException extends RuntimeException {

    public UnauthorizedException() {
        super("Bu işlem için yetkiniz bulunmamaktadır.");
    }

    public UnauthorizedException(String message) {
        super(message);
    }
}
