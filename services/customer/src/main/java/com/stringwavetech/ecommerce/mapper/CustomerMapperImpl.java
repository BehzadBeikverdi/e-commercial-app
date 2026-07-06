package com.stringwavetech.ecommerce.mapper;

import com.stringwavetech.ecommerce.document.CustomerDocument;
import com.stringwavetech.ecommerce.model.request.CustomerRequestModel;
import com.stringwavetech.ecommerce.model.response.CustomerResponseModel;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapperImpl implements CustomerMapper {
    public CustomerDocument toCustomer(CustomerRequestModel request) {
        if (request == null) {
            return null;
        }
        return CustomerDocument.builder()
                .firstname(request.firstname())
                .lastname(request.lastname())
                .email(request.email())
                .address(request.address())
                .build();
    }

    @Override
    public CustomerResponseModel fromCustomer(CustomerDocument customer) {

        CustomerResponseModel.AddressModel address = null;

        if (customer.getAddress() != null) {
            address = new CustomerResponseModel.AddressModel(
                    customer.getAddress().street(),
                    customer.getAddress().houseNumber(),
                    customer.getAddress().zipCode()
            );
        }

        return new CustomerResponseModel(
                customer.getId(),
                customer.getFirstname(),
                customer.getLastname(),
                customer.getEmail(),
                address
        );
    }
}
