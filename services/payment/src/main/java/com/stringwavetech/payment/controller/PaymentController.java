package com.stringwavetech.payment.controller;


import com.stringwavetech.payment.model.BaseResponseModel;
import com.stringwavetech.payment.model.request.PaymentRequestModel;
import com.stringwavetech.payment.service.PaymentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService service;

    @PostMapping
    public BaseResponseModel<String> createPayment(
            @RequestBody @Valid PaymentRequestModel request
    ) {
        return service.createPayment(request);
    }
}
