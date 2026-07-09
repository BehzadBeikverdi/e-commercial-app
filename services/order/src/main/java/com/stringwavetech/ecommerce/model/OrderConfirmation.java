package com.stringwavetech.ecommerce.model;

import com.stringwavetech.ecommerce.enums.PaymentMethodEnum;
import com.stringwavetech.ecommerce.model.response.CustomerResponseModel;
import com.stringwavetech.ecommerce.model.response.PurchaseResponseModel;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(

        String orderReference,
        BigDecimal totalAmount,
        PaymentMethodEnum paymentMethod,
        CustomerResponseModel customer,
        List<PurchaseResponseModel> products
) {
}
