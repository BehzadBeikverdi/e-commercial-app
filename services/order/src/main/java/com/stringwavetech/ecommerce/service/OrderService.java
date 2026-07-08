package com.stringwavetech.ecommerce.service;

import com.stringwavetech.ecommerce.model.BaseResponseModel;
import com.stringwavetech.ecommerce.model.request.OrderRequestModel;
import com.stringwavetech.ecommerce.model.response.OrderResponseModel;

import java.util.List;

public interface OrderService {
    BaseResponseModel<String> createOrder(OrderRequestModel request);

    BaseResponseModel<List<OrderResponseModel>> getAllOrders();

    BaseResponseModel<OrderResponseModel> getOrder(String orderId);
}
