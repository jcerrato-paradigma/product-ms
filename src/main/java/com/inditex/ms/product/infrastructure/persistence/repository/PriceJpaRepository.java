package com.inditex.ms.product.infrastructure.persistence.repository;

import com.inditex.ms.product.infrastructure.persistence.entities.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriceJpaRepository extends JpaRepository<PriceEntity, Integer> {

    @Query(value = "SELECT * FROM prices WHERE product_id = :productId and brand_id = :brandId and start_date <=:date and end_date >= :date", nativeQuery = true)
    List<PriceEntity> findPriceByDate(int productId, int brandId, String date);
}
