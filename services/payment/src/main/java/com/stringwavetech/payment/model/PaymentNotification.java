package com.stringwavetech.payment.model;

import com.stringwavetech.payment.enums.PaymentMethodEnum;

import java.math.BigDecimal;

public record PaymentNotification(

        String orderReference,
        BigDecimal amount,
        PaymentMethodEnum paymentMethod,
        String customerFirstname,
        String customerLastname,
        String customerEmail
) {
}
