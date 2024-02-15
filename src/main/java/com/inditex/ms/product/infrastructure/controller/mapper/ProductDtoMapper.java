package com.inditex.ms.product.infrastructure.controller.mapper;

import com.inditex.ms.product.domain.exception.ProductException;
import com.inditex.ms.product.domain.model.Price;
import com.inditex.ms.product.infrastructure.controller.dto.DateRangeProductPrice;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class ProductDtoMapper {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");
    public LocalDateTime toLocalDateTime(String date) {

        try {
            return LocalDateTime.parse(date, FORMATTER);
        } catch (Exception e) {
            throw new ProductException("Date format not supported. Correct pattern must be 'yyyy-MM-dd-HH.mm.ss'", e, 400);
        }

    }

    public DateRangeProductPrice toDateRangeProductPrice(Price price) {

        return new DateRangeProductPrice()
                .productId(price.getProductId())
                .brandId(price.getBrandId())
                .priceList(price.getPriceList())
                .startDate(this.toDateString(price.getStartDate()))
                .endDate(this.toDateString(price.getEndDate()))
                .price(price.getPrice().toString().concat(" ").concat(price.getCurr()));
    }

    public String toDateString(LocalDateTime date) {

        return date.format(FORMATTER);
    }
}
