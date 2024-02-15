package com.inditex.ms.product.infrastructure.persistence.repository;

import com.inditex.ms.product.domain.PriceRepository;
import com.inditex.ms.product.domain.model.Price;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class PriceRepositoryImpl implements PriceRepository {

    private final PriceJpaRepository priceJpaRepository;

    @Override
    public List<Price> findProductPriceByDate(int productId, int brandId, LocalDateTime date) {
        return null;
    }
}
