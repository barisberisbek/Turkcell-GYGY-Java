package com.turkcell.spring_cqrs.core.exception;

/**
 * HTTP hata yanıtları için standart DTO.
 * RFC 9457 (Problem Details) formatından esinlenmiştir.
 *
 * @param title  Hatanın kısa başlığı (ör. "Unauthorized", "Forbidden")
 * @param status HTTP durum kodu (ör. 401, 403, 400)
 * @param detail Hatanın açıklayıcı mesajı
 */
public record ErrorResponse(
    String title,
    int status,
    String detail
) {}
