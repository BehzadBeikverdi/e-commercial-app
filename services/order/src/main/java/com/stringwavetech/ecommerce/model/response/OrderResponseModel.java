package com.stringwavetech.ecommerce.model.response;

import com.stringwavetech.ecommerce.enums.PaymentMethodEnum;

import java.math.BigDecimal;

public record OrderResponseModel(

        String id,
        String reference,
        BigDecimal amount,
        PaymentMethodEnum paymentMethod,
        String customerId
) {
}
