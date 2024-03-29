package com.inditex.ms.product.infrastructure.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Embeddable
public class ProductEntityId implements Serializable {

    @Column(name = "product_id")
    private Integer id;

    @Column(name = "brand_id")
    private Integer brandId;
}
