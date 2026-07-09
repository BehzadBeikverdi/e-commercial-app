package com.stringwavetech.ecommerce.service;

import com.stringwavetech.ecommerce.model.BaseResponseModel;
import com.stringwavetech.ecommerce.model.request.OrderLineRequestModel;
import com.stringwavetech.ecommerce.model.response.OrderLineResponseModel;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface OrderLineService {

    UUID saveOrderLine(OrderLineRequestModel request);
    BaseResponseModel<List<OrderLineResponseModel>> getAllOrderLineByOrder(String orderId);
}
