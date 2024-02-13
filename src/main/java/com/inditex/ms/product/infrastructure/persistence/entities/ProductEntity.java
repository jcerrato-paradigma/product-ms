package com.inditex.ms.product.infrastructure.persistence.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "products")
public class ProductEntity {

    @EmbeddedId
    private ProductEntityId productId;

    @MapsId("brandId")
    @JoinColumn(name = "brand_id", referencedColumnName = "brand_id")
    @ManyToOne
    private BrandEntity brand;

    @OneToMany(mappedBy = "product")
    private Collection<PriceEntity> prices;
}
