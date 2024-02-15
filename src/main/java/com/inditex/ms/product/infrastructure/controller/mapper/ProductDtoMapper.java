package com.inditex.ms.product.infrastructure.controller.mapper;

import com.inditex.ms.product.domain.exception.ProductException;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class ProductDtoMapper {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");
    public LocalDateTime toLocalDateTime(String date) {

        try {
            return LocalDateTime.parse(date, FORMATTER);
        } catch (Exception e) {
            throw new ProductException("Date format not supported. Correct pattern must be 'yyyy-MM-dd-HH.mm.ss'", e, 400);
        }

    }
}
