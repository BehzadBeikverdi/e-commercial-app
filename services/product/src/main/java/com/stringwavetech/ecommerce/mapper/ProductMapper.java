package com.stringwavetech.ecommerce.mapper;

import com.stringwavetech.ecommerce.entity.ProductEntity;
import com.stringwavetech.ecommerce.model.request.ProductRequestModel;
import com.stringwavetech.ecommerce.model.response.ProductPurchaseResponseModel;
import com.stringwavetech.ecommerce.model.response.ProductResponseModel;

public interface ProductMapper {

    ProductEntity toProduct(ProductRequestModel request);
    ProductResponseModel toProductResponse(ProductEntity product);
    ProductPurchaseResponseModel toProductPurchaseResponse(ProductEntity product, double quantity);
}
