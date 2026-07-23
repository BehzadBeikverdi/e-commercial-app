package com.stringwavetech.payment.service;

import com.stringwavetech.payment.kafka.NotificationProducer;
import com.stringwavetech.payment.mapper.PaymentMapper;
import com.stringwavetech.payment.model.BaseResponseModel;
import com.stringwavetech.payment.model.PaymentNotification;
import com.stringwavetech.payment.model.request.PaymentRequestModel;
import com.stringwavetech.payment.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository repository;
    private final PaymentMapper mapper;
    private final NotificationProducer notificationProducer;

    @Override
     public BaseResponseModel<String> createPayment(PaymentRequestModel request) {

        var payment = repository.save(mapper.toPayment(request));
        this.notificationProducer.sendNotification(
                new PaymentNotification(
                        request.orderReference(),
                        request.amount(),
                        request.paymentMethod(),
                        request.customer().firstname(),
                        request.customer().lastname(),
                        request.customer().email()
                )
        );
        return BaseResponseModel.success("Action Successfully", null);
    }
}
