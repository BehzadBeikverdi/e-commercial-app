package com.stringwavetech.ecommerce.service;

import com.stringwavetech.ecommerce.model.BaseResponseModel;
import com.stringwavetech.ecommerce.model.request.ProductPurchaseRequestModel;
import com.stringwavetech.ecommerce.model.request.ProductRequestModel;
import com.stringwavetech.ecommerce.model.response.ProductPurchaseResponseModel;
import com.stringwavetech.ecommerce.model.response.ProductResponseModel;

import java.util.List;

public interface ProductService {
    BaseResponseModel<String> createProduct(ProductRequestModel request);

    BaseResponseModel<List<ProductPurchaseResponseModel>> purchaseProducts(List<ProductPurchaseRequestModel> request);

    BaseResponseModel<ProductResponseModel> getProduct(String productId);

    BaseResponseModel<List<ProductResponseModel>> getAllProducts();
}
