package com.stringwavetech.payment.mapper;

import com.stringwavetech.payment.entity.PaymentEntity;
import com.stringwavetech.payment.model.request.PaymentRequestModel;
import org.springframework.stereotype.Service;

@Service
public class PaymentMapperImpl implements PaymentMapper {

    @Override
    public PaymentEntity toPayment(PaymentRequestModel request) {

        if (request == null) {
            return null;
        }

        return PaymentEntity.builder()
                .paymentMethod(request.paymentMethod())
                .amount(request.amount())
                .orderId(request.orderId())
                .build();
    }
}
