package com.inditex.ms.product.application.service;

import com.inditex.ms.product.domain.PriceRepository;
import com.inditex.ms.product.domain.model.Price;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
public class PriceService {

    private final PriceRepository priceRepository;

    public Price findProductPrice(Integer productId, Integer brandId, LocalDateTime applicationDate) {

        final List<Price> pricesByDate = priceRepository.findProductPriceByDate(productId, brandId, applicationDate);

        return new Price(1, 1, LocalDateTime.now(), LocalDateTime.now().plusHours(10), 1, 12345, 0, new BigDecimal("23.50"), "EUR");
    }
}
