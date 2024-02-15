package com.inditex.ms.product.infrastructure.persistence.repository;

import com.inditex.ms.product.domain.PriceRepository;
import com.inditex.ms.product.domain.model.Price;
import com.inditex.ms.product.infrastructure.persistence.repository.mapper.JpaRepositoryMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Import({PriceRepositoryImpl.class, JpaRepositoryMapper.class})
public class PriceRepositoryTest {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");

    @Autowired
    private PriceRepository priceRepository;

    @Test
    void givenProductBrandAndDate_returnPriceList() {

        int productId = 35455;
        int brandId = 1;
        final LocalDateTime applicationDate = LocalDateTime.parse("2020-06-14-16.00.00", FORMATTER);

        final List<Price> prices = priceRepository.findProductPriceByDate(productId, brandId, applicationDate);

        assertEquals(2, prices.size());

        final Price price1 = prices.get(0);
        final Price price2 = prices.get(1);

        assertEquals(productId, price1.getProductId());
        assertEquals(productId, price2.getProductId());
        assertEquals(brandId, price1.getBrandId());
        assertEquals(brandId, price2.getBrandId());
        assertTrue(applicationDate.isAfter(price1.getStartDate()));
        assertTrue(applicationDate.isAfter(price2.getStartDate()));
        assertTrue(applicationDate.isBefore(price1.getEndDate()));
        assertTrue(applicationDate.isBefore(price2.getEndDate()));
    }


}
