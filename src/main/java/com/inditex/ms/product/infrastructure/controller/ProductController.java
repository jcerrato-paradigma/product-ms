package com.inditex.ms.product.infrastructure.controller;

import com.inditex.ms.product.application.service.PriceService;
import com.inditex.ms.product.domain.model.Price;
import com.inditex.ms.product.infrastructure.controller.dto.DateRangeProductPrice;
import com.inditex.ms.product.infrastructure.controller.mapper.ProductDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class ProductController implements ProductApi {

    private final PriceService priceService;

    private final ProductDtoMapper mapper;

    @Override
    public ResponseEntity<DateRangeProductPrice> findProductPrice(Integer productId, Integer brandId, String applicationDate) {

        final LocalDateTime date = mapper.toLocalDateTime(applicationDate);
        final Price price = priceService.findProductPrice(productId, brandId, date);

        return ResponseEntity.ok(mapper.toDateRangeProductPrice(price));
    }
}
