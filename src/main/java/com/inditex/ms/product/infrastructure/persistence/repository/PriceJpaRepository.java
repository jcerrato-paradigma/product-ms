package com.inditex.ms.product.infrastructure.persistence.repository;

import com.inditex.ms.product.infrastructure.persistence.entities.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceJpaRepository extends JpaRepository<PriceEntity, Integer> {
}
