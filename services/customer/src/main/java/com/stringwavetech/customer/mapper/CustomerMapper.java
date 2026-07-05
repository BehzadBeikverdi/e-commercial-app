package com.stringwavetech.customer.mapper;

import com.stringwavetech.customer.entity.CustomerDocument;
import com.stringwavetech.customer.model.request.CustomerRequestModel;
import com.stringwavetech.customer.model.response.CustomerResponseModel;

public interface CustomerMapper {

    CustomerDocument toCustomer(CustomerRequestModel request);

    CustomerResponseModel fromCustomer(CustomerDocument customer);
}
