package com.inditex.ms.product.application.service;

import com.inditex.ms.product.domain.PriceRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PriceService {

    private final PriceRepository priceRepository;
}
