package com.inditex.ms.product.infrastructure.configuration;

import com.inditex.ms.product.application.service.PriceService;
import com.inditex.ms.product.domain.PriceRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PriceConfiguration {

    @Bean
    public PriceService priceService(PriceRepository priceRepository) {

        return new PriceService(priceRepository);
    }
}
