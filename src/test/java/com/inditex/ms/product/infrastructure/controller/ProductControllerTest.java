package com.inditex.ms.product.infrastructure.controller;

import com.inditex.ms.product.application.service.PriceService;
import com.inditex.ms.product.domain.model.Price;
import com.inditex.ms.product.infrastructure.controller.mapper.ProductDtoMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
@Import(ProductDtoMapper.class)
public class ProductControllerTest {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PriceService priceService;

    @Test
    void givenProductBrandAndDate_returnPrice() throws Exception {

        final Integer productId = 35455;
        final Integer brandId = 1;
        final LocalDateTime now = LocalDateTime.now();
        final String applicationDate = now.format(FORMATTER);

        final Price price = new Price(
                1,
                brandId,
                now.minusHours(3),
                now.plusHours(3),
                1,
                productId,
                1,
                new BigDecimal("23.50"),
                "EUR");

        when(priceService.findProductPrice(productId, brandId, LocalDateTime.parse(applicationDate, FORMATTER)))
                .thenReturn(price);

        this.mockMvc
                .perform(get("/product/{productId}/price", productId)
                        .param("brand_id", String.valueOf(brandId))
                        .param("application_date", applicationDate))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.product_id").value(productId))
                .andExpect(jsonPath("$.brand_id").value(brandId));
    }

    @Test
    void givenWrongDate_returnBadRequest() throws Exception {

        this.mockMvc
                .perform(get("/product/{productId}/price", 1)
                        .param("brand_id", String.valueOf(1))
                        .param("application_date", "wrongDate"))
                .andExpect(status().isBadRequest());
    }
}
