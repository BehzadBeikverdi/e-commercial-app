package com.stringwavetech.ecommerce.client;

import com.stringwavetech.ecommerce.model.request.PaymentRequestModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@FeignClient(
        name = "product-service",
        url = "${application.config.payment-url}"
)
public interface PaymentClient {

    @PostMapping
    UUID requestOrderPayment(@RequestBody PaymentRequestModel request);
}
