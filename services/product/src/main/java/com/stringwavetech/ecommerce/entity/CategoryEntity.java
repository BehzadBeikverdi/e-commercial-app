package com.stringwavetech.ecommerce.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity(name = BaseEntity.PREFIX + "category")
public class CategoryEntity extends BaseEntity {

    private String name;
    private String description;
    @OneToMany(mappedBy = "categoryEntity", cascade = CascadeType.REMOVE)
    private List<ProductEntity> products;
}