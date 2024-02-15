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
    private Integer priceId;

    @Column(name = "start_date")
    private String startDate;

    @Column(name = "end_date")
    private String endDate;

    @Column(name = "price_list")
    private Integer priceList;

    private Integer priority;

    private String price;

    private String curr;

    @JoinColumns({
            @JoinColumn(name = "product_id", referencedColumnName = "product_id"),
            @JoinColumn(name = "brand_id", referencedColumnName = "brand_id")
    })
    @ManyToOne
    private ProductEntity product;
}
