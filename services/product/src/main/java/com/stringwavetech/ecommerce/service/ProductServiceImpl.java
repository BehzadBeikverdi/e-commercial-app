package com.stringwavetech.ecommerce.service;

import com.stringwavetech.ecommerce.exceptions.NotFoundException;
import com.stringwavetech.ecommerce.mapper.ProductMapper;
import com.stringwavetech.ecommerce.model.BaseResponseModel;
import com.stringwavetech.ecommerce.model.request.ProductPurchaseRequestModel;
import com.stringwavetech.ecommerce.model.request.ProductRequestModel;
import com.stringwavetech.ecommerce.model.response.ProductPurchaseResponseModel;
import com.stringwavetech.ecommerce.model.response.ProductResponseModel;
import com.stringwavetech.ecommerce.repository.ProductRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    private final ProductMapper mapper;

    @Override
    public BaseResponseModel<String> createProduct(ProductRequestModel request) {

        repository.save(mapper.toProduct(request));

        return BaseResponseModel.success("Action Successfully", null);
    }

    @Override
    @Transactional(rollbackFor = NotFoundException.class)
    public BaseResponseModel<List<ProductPurchaseResponseModel>> purchaseProducts(List<ProductPurchaseRequestModel> request) {

        var productIds = request
                .stream()
                .map(r -> UUID.fromString(r.productId()))
                .toList();

        var storedProducts = repository.findAllByIdInOrderById(productIds);

        if (productIds.size() != storedProducts.size()) {
            throw new NotFoundException("One or more products does not exist");
        }

        var sortedRequest = request
                .stream()
                .sorted(Comparator.comparing(ProductPurchaseRequestModel::productId))
                .toList();

        var purchasedProducts = new ArrayList<ProductPurchaseResponseModel>();

        for (int i = 0; i < storedProducts.size(); i++) {
            var product = storedProducts.get(i);
            var productRequest = sortedRequest.get(i);
            if (product.getAvailableQuantity() < productRequest.quantity()) {
                throw new NotFoundException("Insufficient stock quantity for product with ID:: " + productRequest.productId());
            }
            var newAvailableQuantity = product.getAvailableQuantity() - productRequest.quantity();
            product.setAvailableQuantity(newAvailableQuantity);
            repository.save(product);
            purchasedProducts.add(mapper.toProductPurchaseResponse(product, productRequest.quantity()));
        }

        return BaseResponseModel.success("Action Successfully", purchasedProducts);
    }

    @Override
    public BaseResponseModel<ProductResponseModel> getProduct(String productId) {

        return BaseResponseModel.success("Action Successfully", findProductById(productId));
    }

    @Override
    public BaseResponseModel<List<ProductResponseModel>> getAllProducts() {

        return BaseResponseModel.success("Action Successfully", findAllProducts());
    }

    private ProductResponseModel findProductById(String customerId) {

        return repository.findById(UUID.fromString(customerId))
                .map(mapper::toProductResponse)
                .orElseThrow(() ->
                        new NotFoundException(
                                String.format("Customer not found with id: %s", customerId)
                        )
                );
    }

    private List<ProductResponseModel> findAllProducts() {

        return repository.findAll()
                .stream()
                .map(mapper::toProductResponse)
                .collect(Collectors.toList());
    }
}
