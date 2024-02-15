package com.inditex.ms.product.infrastructure.controller;

import com.inditex.ms.product.infrastructure.controller.dto.DateRangeProductPrice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
    public class ProductController implements ProductApi {


    @Override
    public ResponseEntity<DateRangeProductPrice> findProductPrice(Integer productId, Integer brandId, String applicationDate) {
        return ResponseEntity.ok(new DateRangeProductPrice().productId(productId+1).brandId(brandId+1));
    }
}
