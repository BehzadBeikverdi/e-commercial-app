package com.stringwavetech.ecommerce.contoller;

import com.stringwavetech.ecommerce.model.BaseResponseModel;
import com.stringwavetech.ecommerce.model.request.ProductPurchaseRequestModel;
import com.stringwavetech.ecommerce.model.request.ProductRequestModel;
import com.stringwavetech.ecommerce.model.response.ProductPurchaseResponseModel;
import com.stringwavetech.ecommerce.model.response.ProductResponseModel;
import com.stringwavetech.ecommerce.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @PostMapping
    public BaseResponseModel<String> createProduct(
            @RequestBody @Valid ProductRequestModel request
    ) {

        return service.createProduct(request);
    }

    @PostMapping("/purchase")
    public BaseResponseModel<List<ProductPurchaseResponseModel>> purchaseProducts(
            @RequestBody List<ProductPurchaseRequestModel> request
    ) {
        return service.purchaseProducts(request);
    }

    @GetMapping("/{product-id}")
    public BaseResponseModel<ProductResponseModel> findProduct(
            @PathVariable("product-id") String productId
    ) {
        return service.getProduct(productId);
    }

    @GetMapping
    public BaseResponseModel<List<ProductResponseModel>> getAllProducts() {
        return service.getAllProducts();
    }
}