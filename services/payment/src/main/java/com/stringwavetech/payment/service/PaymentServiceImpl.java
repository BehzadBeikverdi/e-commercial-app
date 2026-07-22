package com.stringwavetech.payment.service;

import com.stringwavetech.payment.mapper.PaymentMapper;
import com.stringwavetech.payment.model.BaseResponseModel;
import com.stringwavetech.payment.model.request.PaymentRequestModel;
import com.stringwavetech.payment.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository repository;
    private final PaymentMapper mapper;

    @Override
    public BaseResponseModel<Integer> createPayment(PaymentRequestModel request) {

        var payment = repository.save(mapper.toPayment(request));
        return null;
    }
}
