package com.stringwavetech.ecommerce.controller;

import com.stringwavetech.ecommerce.model.BaseResponseModel;
import com.stringwavetech.ecommerce.model.request.OrderRequestModel;
import com.stringwavetech.ecommerce.model.response.OrderResponseModel;
import com.stringwavetech.ecommerce.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService service;

    @PostMapping
    public BaseResponseModel<String> createOrder(
            @RequestBody @Valid OrderRequestModel request
    ) {

        return service.createOrder(request);
    }

    @GetMapping
    public BaseResponseModel<List<OrderResponseModel>> getAllOrders() {

        return service.getAllOrders();
    }

    @GetMapping("/{orderId}")
    public BaseResponseModel<OrderResponseModel> getOrder(
            @PathVariable String orderId
    ) {

        return service.getOrder(orderId);
    }
}
