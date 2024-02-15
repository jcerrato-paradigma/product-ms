package com.inditex.ms.product.application.service;

import com.inditex.ms.product.domain.PriceRepository;
import com.inditex.ms.product.domain.exception.ProductException;
import com.inditex.ms.product.domain.model.Price;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@RequiredArgsConstructor
public class PriceService {

    private final PriceRepository priceRepository;

    public Price findProductPrice(Integer productId, Integer brandId, LocalDateTime applicationDate) {

        final List<Price> pricesByDate = priceRepository.findProductPriceByDate(productId, brandId, applicationDate);

        return pricesByDate.stream()
                .max(Comparator.comparing(Price::getPriority))
                .orElseThrow(() -> new ProductException("No product was found", null, 404));
    }
}
