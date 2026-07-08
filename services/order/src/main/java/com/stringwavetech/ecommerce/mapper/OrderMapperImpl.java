package com.stringwavetech.ecommerce.mapper;

import com.stringwavetech.ecommerce.entity.OrderEntity;
import com.stringwavetech.ecommerce.model.request.OrderRequestModel;
import com.stringwavetech.ecommerce.model.response.OrderResponseModel;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderMapperImpl implements OrderMapper {

    @Override
    public OrderEntity toOrder(OrderRequestModel request) {

        if (request == null) {
            return null;
        }
        return OrderEntity.builder()
                .reference(request.reference())
                .paymentMethod(request.paymentMethod())
                .customerId(UUID.fromString(request.customerId()))
                .build();
    }

    @Override
    public OrderResponseModel fromOrder(OrderEntity order) {

        return new OrderResponseModel(
                order.getId().toString(),
                order.getReference(),
                order.getTotalAmount(),
                order.getPaymentMethod(),
                order.getCustomerId().toString()
        );
    }
}
