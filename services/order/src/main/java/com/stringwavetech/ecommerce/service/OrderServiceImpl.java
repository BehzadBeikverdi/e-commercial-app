package com.stringwavetech.ecommerce.service;

import com.stringwavetech.ecommerce.client.CustomerClient;
import com.stringwavetech.ecommerce.client.ProductClient;
import com.stringwavetech.ecommerce.exceptions.BusinessException;
import com.stringwavetech.ecommerce.mapper.OrderMapper;
import com.stringwavetech.ecommerce.model.BaseResponseModel;
import com.stringwavetech.ecommerce.model.request.OrderRequestModel;
import com.stringwavetech.ecommerce.model.response.OrderResponseModel;
import com.stringwavetech.ecommerce.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repository;
    private final CustomerClient customerClient;
    private final ProductClient productClient;
    private final OrderMapper mapper;

    @Override
    public BaseResponseModel<String> createOrder(OrderRequestModel request) {

        var customer = customerClient.findCustomerById(request.customerId())
                .orElseThrow(() -> new BusinessException("No customer exists with ID: " + request.customerId()));

        var purchasedProducts = productClient.purchaseProducts(request.products());

        var order = this.repository.save(mapper.toOrder(request));

        return null;
    }

    @Override
    public BaseResponseModel<List<OrderResponseModel>> getAllOrders() {
        return null;
    }

    @Override
    public BaseResponseModel<OrderResponseModel> getOrder(String orderId) {
        return null;
    }
}
