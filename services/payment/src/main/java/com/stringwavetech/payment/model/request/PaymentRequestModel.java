package com.stringwavetech.payment.model.request;

import com.stringwavetech.payment.enums.PaymentMethodEnum;
import com.stringwavetech.payment.model.CustomerModel;

import java.math.BigDecimal;

public record PaymentRequestModel(

        BigDecimal amount,
        PaymentMethodEnum paymentMethod,
        Integer orderId,
        String orderReference,
        CustomerModel customer
) {
}
