package com.inditex.ms.product.infrastructure.controller;

import com.inditex.ms.product.application.service.PriceService;
import com.inditex.ms.product.infrastructure.controller.dto.DateRangeProductPrice;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductController implements ProductApi {

    private final PriceService priceService;

    @Override
    public ResponseEntity<DateRangeProductPrice> findProductPrice(Integer productId, Integer brandId, String applicationDate) {


        return ResponseEntity.ok(new DateRangeProductPrice().productId(productId + 1).brandId(brandId + 1));
    }
}
