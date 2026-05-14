package com.turkcell.spring_cqrs.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.turkcell.spring_cqrs.core.exception.ErrorResponse;
import com.turkcell.spring_cqrs.core.exception.UnauthenticatedException;
import com.turkcell.spring_cqrs.core.exception.UnauthorizedException;

/**
 * Uygulama genelindeki exception'ları yakalayarak
 * standart {@link ErrorResponse} formatında HTTP yanıtı döndürür.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UnauthenticatedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ErrorResponse handleUnauthenticated(UnauthenticatedException exception) {
        return new ErrorResponse(
            "Unauthorized",
            HttpStatus.UNAUTHORIZED.value(),
            exception.getMessage()
        );
    }

    @ExceptionHandler(UnauthorizedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ErrorResponse handleUnauthorized(UnauthorizedException exception) {
        return new ErrorResponse(
            "Forbidden",
            HttpStatus.FORBIDDEN.value(),
            exception.getMessage()
        );
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleRuntimeException(RuntimeException exception) {
        return new ErrorResponse(
            "Bad Request",
            HttpStatus.BAD_REQUEST.value(),
            exception.getMessage()
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleValidationException(MethodArgumentNotValidException exception) {
        String detail = exception.getBindingResult().getFieldErrors().stream()
            .map(error -> error.getField() + ": " + error.getDefaultMessage())
            .reduce((a, b) -> a + "; " + b)
            .orElse(exception.getMessage());

        return new ErrorResponse(
            "Validation Failed",
            HttpStatus.BAD_REQUEST.value(),
            detail
        );
    }
}
