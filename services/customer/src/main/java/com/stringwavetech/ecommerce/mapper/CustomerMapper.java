package com.stringwavetech.ecommerce.mapper;

import com.stringwavetech.ecommerce.document.CustomerDocument;
import com.stringwavetech.ecommerce.model.request.CustomerRequestModel;
import com.stringwavetech.ecommerce.model.response.CustomerResponseModel;

public interface CustomerMapper {

    CustomerDocument toCustomer(CustomerRequestModel request);

    CustomerResponseModel fromCustomer(CustomerDocument customer);
}
