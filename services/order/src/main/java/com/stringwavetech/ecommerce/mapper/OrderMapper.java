package com.stringwavetech.ecommerce.mapper;

import com.stringwavetech.ecommerce.entity.OrderEntity;
import com.stringwavetech.ecommerce.model.request.OrderRequestModel;
import com.stringwavetech.ecommerce.model.response.OrderResponseModel;

public interface OrderMapper {

    OrderEntity toOrder(OrderRequestModel request);
    OrderResponseModel fromOrder(OrderEntity order);
}
