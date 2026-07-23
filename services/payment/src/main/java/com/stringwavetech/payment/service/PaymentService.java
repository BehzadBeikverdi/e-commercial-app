package com.stringwavetech.payment.service;

import com.stringwavetech.payment.model.BaseResponseModel;
import com.stringwavetech.payment.model.request.PaymentRequestModel;
import jakarta.validation.Valid;

public interface PaymentService {

    BaseResponseModel<String> createPayment(@Valid PaymentRequestModel request);
}
