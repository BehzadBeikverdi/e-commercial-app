package com.stringwavetech.payment.mapper;

import com.stringwavetech.payment.entity.PaymentEntity;
import com.stringwavetech.payment.model.request.PaymentRequestModel;

public interface PaymentMapper {

    PaymentEntity toPayment(PaymentRequestModel request);
}
