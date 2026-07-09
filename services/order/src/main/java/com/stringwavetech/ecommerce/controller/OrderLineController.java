package com.stringwavetech.ecommerce.controller;

import com.stringwavetech.ecommerce.model.BaseResponseModel;
import com.stringwavetech.ecommerce.model.response.OrderLineResponseModel;
import com.stringwavetech.ecommerce.service.OrderLineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order-lines")
@RequiredArgsConstructor
public class OrderLineController {

    private final OrderLineService service;

    @GetMapping("/order/{orderId}")
    public BaseResponseModel<List<OrderLineResponseModel>> getAllOrderLineByOrder(
            @PathVariable String orderId
    ) {
        return service.getAllOrderLineByOrder(orderId);
    }
}
