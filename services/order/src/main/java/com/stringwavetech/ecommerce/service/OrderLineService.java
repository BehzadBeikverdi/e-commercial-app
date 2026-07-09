package com.stringwavetech.ecommerce.service;

import com.stringwavetech.ecommerce.model.BaseResponseModel;
import com.stringwavetech.ecommerce.model.response.OrderLineResponseModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OrderLineService {
    BaseResponseModel<List<OrderLineResponseModel>> getAllOrderLineByOrder(String orderId);
}
