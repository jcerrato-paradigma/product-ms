package com.inditex.ms.product.application.service;

import com.inditex.ms.product.domain.PriceRepository;
import com.inditex.ms.product.domain.exception.ProductException;
import com.inditex.ms.product.domain.model.Price;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PriceServiceTest {

    @Mock
    PriceRepository priceRepository;

    PriceService priceService;

    @BeforeEach
    void setup() {

        priceService = new PriceService(priceRepository);
    }

    @Test
    void givenOnePriceReturnedFromDatabase_returnThisPrice() {

        final int productId = 35455;
        final int brandId = 1;
        final LocalDateTime applicationDate = LocalDateTime.now();

        Price price = new Price(
                1,
                brandId,
                LocalDateTime.now(),
                LocalDateTime.now(),
                1,
                productId,
                1,
                new BigDecimal("20.25"),
                "EUR");

        when(priceRepository.findProductPriceByDate(productId, brandId, applicationDate))
                .thenReturn(Collections.singletonList(price));

        final Price priceReturned = priceService.findProductPrice(productId, brandId, applicationDate);

        assertEquals(price, priceReturned);
    }

    @Test
    void givenTwoPricesReturnedFromDatabase_returnPriceWithHigherPriority() {

        final int productId = 35455;
        final int brandId = 1;
        final LocalDateTime applicationDate = LocalDateTime.now();

        Price price1 = new Price(
                1,
                brandId,
                LocalDateTime.now(),
                LocalDateTime.now(),
                1,
                productId,
                1,
                new BigDecimal("20.25"),
                "EUR");

        Price price2 = new Price(
                1,
                brandId,
                LocalDateTime.now(),
                LocalDateTime.now(),
                1,
                productId,
                0,
                new BigDecimal("30.10"),
                "EUR");

        when(priceRepository.findProductPriceByDate(productId, brandId, applicationDate))
                .thenReturn(List.of(price1, price2));

        final Price priceReturned = priceService.findProductPrice(productId, brandId, applicationDate);

        assertEquals(price1, priceReturned);
    }

    @Test
    void givenNoPriceReturnedFromDatabase_throwException() {

        final int productId = 35455;
        final int brandId = 1;
        final LocalDateTime applicationDate = LocalDateTime.now();

        when(priceRepository.findProductPriceByDate(productId, brandId, applicationDate))
                .thenReturn(Collections.emptyList());


        final ProductException productException = assertThrows(ProductException.class,
                () -> priceService.findProductPrice(productId, brandId, applicationDate));

        assertEquals(404, productException.getHttpStatus());
    }
}
