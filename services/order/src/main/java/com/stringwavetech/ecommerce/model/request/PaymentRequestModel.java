package com.stringwavetech.ecommerce.model.request;

import com.stringwavetech.ecommerce.enums.PaymentMethodEnum;
import com.stringwavetech.ecommerce.model.response.CustomerResponseModel;

import java.math.BigDecimal;
import java.util.UUID;

public record PaymentRequestModel(

        BigDecimal amount,
        PaymentMethodEnum paymentMethod,
        UUID orderId,
        String orderReference,
        CustomerResponseModel customer
) {
}
