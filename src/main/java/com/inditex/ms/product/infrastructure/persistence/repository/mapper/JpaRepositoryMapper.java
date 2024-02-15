package com.inditex.ms.product.infrastructure.persistence.repository.mapper;

import com.inditex.ms.product.domain.exception.ProductException;
import com.inditex.ms.product.domain.model.Price;
import com.inditex.ms.product.infrastructure.persistence.entities.PriceEntity;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class JpaRepositoryMapper {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");

    public String toDateString(LocalDateTime date) {

        return date.format(FORMATTER);
    }

    public List<Price> toPriceList(List<PriceEntity> pricesByDate) {

        return pricesByDate.stream()
                .map(priceEntity -> {
                    Price price = new Price();
                    price.setPriceId(priceEntity.getPriceId());
                    price.setBrandId(priceEntity.getProduct().getBrand().getBrandId());
                    price.setStartDate(this.toLocalDateTime(priceEntity.getStartDate()));
                    price.setEndDate(this.toLocalDateTime(priceEntity.getEndDate()));
                    price.setPriceList(priceEntity.getPriceList());
                    price.setProductId(priceEntity.getProduct().getProductId().getId());
                    price.setPriority(priceEntity.getPriority());
                    price.setPrice(new BigDecimal(priceEntity.getPrice()));
                    price.setCurr(priceEntity.getCurr());
                    return price;
                })
                .collect(Collectors.toList());
    }

    public LocalDateTime toLocalDateTime(String date) {

        try {
            return LocalDateTime.parse(date, FORMATTER);
        } catch (Exception e) {
            throw new ProductException("Date format not supported. Correct pattern must be 'yyyy-MM-dd-HH.mm.ss'", e, 400);
        }
    }
}
