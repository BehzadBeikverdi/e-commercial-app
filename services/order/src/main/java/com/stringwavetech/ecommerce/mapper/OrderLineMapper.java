package com.stringwavetech.ecommerce.mapper;

import com.stringwavetech.ecommerce.entity.OrderLineEntity;
import com.stringwavetech.ecommerce.model.request.OrderLineRequestModel;
import com.stringwavetech.ecommerce.model.response.OrderLineResponseModel;

public interface OrderLineMapper {

    OrderLineEntity toOrderLine(OrderLineRequestModel request);

    OrderLineResponseModel toOrderLineResponse(OrderLineEntity orderLine);
}
