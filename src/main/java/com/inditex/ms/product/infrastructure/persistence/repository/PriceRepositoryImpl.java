package com.inditex.ms.product.infrastructure.persistence.repository;

import com.inditex.ms.product.domain.PriceRepository;
import com.inditex.ms.product.domain.model.Price;
import com.inditex.ms.product.infrastructure.persistence.entities.PriceEntity;
import com.inditex.ms.product.infrastructure.persistence.repository.mapper.JpaRepositoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class PriceRepositoryImpl implements PriceRepository {

    private final PriceJpaRepository priceJpaRepository;

    private final JpaRepositoryMapper mapper;

    @Override
    public List<Price> findProductPriceByDate(int productId, int brandId, LocalDateTime applicationDate) {

        String date = mapper.toDateString(applicationDate);
        final List<PriceEntity> pricesByDate = priceJpaRepository.findPriceByDate(productId, brandId, date);
        return mapper.toPriceList(pricesByDate);
    }
}
