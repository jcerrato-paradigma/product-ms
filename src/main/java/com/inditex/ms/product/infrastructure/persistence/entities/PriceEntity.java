package com.inditex.ms.product.infrastructure.persistence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "prices")
public class PriceEntity {

    @Id
    @Column(name = "price_id")
    private Long priceId;

    @Column(name = "brand_id")
    private Integer brandId;

    @Column(name = "start_date")
    private String startDate;

    @Column(name = "end_date")
    private String endDate;

    @Column(name = "price_list")
    private Integer priceList;

    @Column(name = "product_id")
    private Long productId;

    private Integer priority;

    private String price;

    private String curr;

    @JoinColumns({
            @JoinColumn(referencedColumnName = "product_id"),
            @JoinColumn(referencedColumnName = "brand_id")
    })
    @ManyToOne
    private ProductEntity product;
}
