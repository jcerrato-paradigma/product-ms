package com.inditex.ms.product.domain;

import com.inditex.ms.product.domain.model.Price;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceRepository {

    List<Price> findProductPriceByDate(int productId, int brandId, LocalDateTime date);
}
