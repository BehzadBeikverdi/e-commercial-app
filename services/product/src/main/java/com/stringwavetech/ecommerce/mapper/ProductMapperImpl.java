package com.stringwavetech.ecommerce.mapper;

import com.stringwavetech.ecommerce.entity.CategoryEntity;
import com.stringwavetech.ecommerce.entity.ProductEntity;
import com.stringwavetech.ecommerce.model.request.ProductRequestModel;
import com.stringwavetech.ecommerce.model.response.ProductPurchaseResponseModel;
import com.stringwavetech.ecommerce.model.response.ProductResponseModel;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductEntity toProduct(ProductRequestModel request) {

        CategoryEntity category = new CategoryEntity();
        category.setId(UUID.fromString(request.categoryId()));

        return ProductEntity.builder()
                .name(request.name())
                .description(request.description())
                .availableQuantity(request.availableQuantity())
                .price(request.price())
                .categoryEntity(category)
                .build();
    }

    @Override
    public ProductResponseModel toProductResponse(ProductEntity product) {

        return new ProductResponseModel(
                product.getId().toString(),
                product.getName(),
                product.getDescription(),
                product.getAvailableQuantity(),
                product.getPrice(),
                product.getCategoryEntity().getId().toString(),
                product.getCategoryEntity().getName(),
                product.getCategoryEntity().getDescription()
        );
    }

    @Override
    public ProductPurchaseResponseModel toProductPurchaseResponse(ProductEntity product, double quantity) {

        return new ProductPurchaseResponseModel(
                product.getId().toString(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                quantity
        );
    }
}
