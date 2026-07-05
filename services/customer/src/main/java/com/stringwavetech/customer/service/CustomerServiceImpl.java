package com.stringwavetech.customer.service;

import ch.qos.logback.core.util.StringUtil;
import com.stringwavetech.customer.entity.CustomerDocument;
import com.stringwavetech.customer.exceptions.NotFoundException;
import com.stringwavetech.customer.mapper.CustomerMapper;
import com.stringwavetech.customer.model.BaseResponseModel;
import com.stringwavetech.customer.model.request.CustomerRequestModel;
import com.stringwavetech.customer.model.response.CustomerResponseModel;
import com.stringwavetech.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;
    private final CustomerMapper mapper;

    @Override
    public BaseResponseModel<String> createCustomer(CustomerRequestModel request) {

        repository.save(mapper.toCustomer(request));

        return BaseResponseModel.success("Action Successfully", null);
    }

    @Override
    public BaseResponseModel<String> updateCustomer(String customerId, CustomerRequestModel request) {

        var customer = repository.findById(UUID.fromString(customerId))
                .orElseThrow(() -> new NotFoundException(
                        String.format("Customer not found with ID: %s", customerId)
                ));

        mergeCustomer(customer, request);
        repository.save(customer);

        return BaseResponseModel.success("Action Successfully", null);
    }

    @Override
    public BaseResponseModel<List<CustomerResponseModel>> getAllCustomers() {

        return BaseResponseModel.success("Action Successfully", findAllCustomers());
    }

    @Override
    public BaseResponseModel<CustomerResponseModel> getCustomer(String customerId) {

        return BaseResponseModel.success("Action Successfully", findCustomerById(customerId));
    }

    @Override
    public BaseResponseModel<CustomerResponseModel> deleteCustomer(String customerId) {

        return BaseResponseModel.success("Action Successfully", deleteCustomerById(customerId));
    }

    private void mergeCustomer(CustomerDocument customer, CustomerRequestModel request) {

        if (StringUtil.isNullOrEmpty(request.firstname())) {
            customer.setFirstname(request.firstname());
        }

        if (StringUtil.isNullOrEmpty(request.lastname())) {
            customer.setLastname(request.lastname());
        }

        if (StringUtil.isNullOrEmpty(request.email())) {
            customer.setEmail(request.email());
        }

        if (request.address() != null ) {
            customer.setAddress(request.address());
        }
    }

    private List<CustomerResponseModel> findAllCustomers() {

        return repository.findAll()
                .stream()
                .map(mapper::fromCustomer)
                .collect(Collectors.toList());
    }

    private CustomerResponseModel findCustomerById(String customerId) {

        return repository.findById(UUID.fromString(customerId))
                .map(mapper::fromCustomer)
                .orElseThrow(() ->
                        new NotFoundException(
                                String.format("Customer not found with id: %s", customerId)
                        )
                );
    }

    private CustomerResponseModel deleteCustomerById(String customerId) {

        UUID id = UUID.fromString(customerId);

        CustomerDocument customer = repository.findById(id)
                .orElseThrow(() ->
                        new NotFoundException(
                                String.format("Customer not found with id: %s", customerId)
                        )
                );

        repository.deleteById(id);

        return mapper.fromCustomer(customer);
    }


}
