package com.stringwavetech.ecommerce.mapper;

import com.stringwavetech.ecommerce.entity.OrderEntity;
import com.stringwavetech.ecommerce.entity.OrderLineEntity;
import com.stringwavetech.ecommerce.model.request.OrderLineRequestModel;
import com.stringwavetech.ecommerce.model.response.OrderLineResponseModel;
import org.springframework.stereotype.Service;

@Service
public class OrderLineMapperImpl implements OrderLineMapper {

    @Override
    public OrderLineEntity toOrderLine(OrderLineRequestModel request) {

        OrderEntity order = new OrderEntity();
        order.setId(request.orderId());

        return OrderLineEntity.builder()
                .productId(request.productId())
                .order(order)
                .quantity(request.quantity())
                .build();
    }

    @Override
    public OrderLineResponseModel toOrderLineResponse(OrderLineEntity orderLine) {

        return new OrderLineResponseModel(
                orderLine.getId(),
                orderLine.getQuantity()
        );
    }
}
