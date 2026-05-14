package com.turkcell.spring_starter.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// Kütüphane projenizde:
// Ödev: Bilindik hata türleri için yönetimi düzgünleştir.
// RuntimeException çok genel olduğu için, kendimize özel Exception türleri yaratıp onları yakalamak. (BusinessException)
// ErrorResponse -> {title, type, message}
// ValidationErrorResponse -> {arguments: []}
@RestControllerAdvice
public class GlobalExceptionHandler {
   @ExceptionHandler({RuntimeException.class})
   @ResponseStatus(HttpStatus.BAD_REQUEST)
   public String handleRuntimeException(RuntimeException exception) {
        return exception.getMessage();
   }

   @ExceptionHandler({MethodArgumentNotValidException.class})
   @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleValidationException(MethodArgumentNotValidException exception) {
        return exception.getMessage();
   }
}
