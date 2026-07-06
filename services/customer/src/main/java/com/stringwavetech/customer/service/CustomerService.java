package com.stringwavetech.customer.service;

import com.stringwavetech.customer.model.BaseResponseModel;
import com.stringwavetech.customer.model.request.CustomerRequestModel;
import com.stringwavetech.customer.model.response.CustomerResponseModel;
import jakarta.validation.Valid;

import java.util.List;

public interface CustomerService {
    BaseResponseModel<String> createCustomer(@Valid CustomerRequestModel request);

    BaseResponseModel<String> updateCustomer(@Valid String customerId, @Valid CustomerRequestModel request);

    BaseResponseModel<List<CustomerResponseModel>> getAllCustomers();

    BaseResponseModel<CustomerResponseModel> getCustomer(@Valid String customerId);

    BaseResponseModel<CustomerResponseModel> deleteCustomer(@Valid String customerId);

    BaseResponseModel<Boolean> findCustomer(@Valid String customerId);
}
