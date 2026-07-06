package com.stringwavetech.ecommerce.controller;

import com.stringwavetech.ecommerce.model.request.CustomerRequestModel;
import com.stringwavetech.ecommerce.model.response.CustomerResponseModel;
import com.stringwavetech.ecommerce.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import com.stringwavetech.ecommerce.model.BaseResponseModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService service;

    @PostMapping
    public BaseResponseModel<String> createCustomer(@RequestBody @Valid CustomerRequestModel request) {

        return service.createCustomer(request);
    }

    @PutMapping("/{customerId}")
    public BaseResponseModel<String> updateCustomer(@PathVariable @Valid String customerId, @RequestBody @Valid CustomerRequestModel request) {

        return service.updateCustomer(customerId, request);
    }

    @GetMapping
    public BaseResponseModel<List<CustomerResponseModel>> getAllCustomers() {

        return service.getAllCustomers();
    }

    @GetMapping("/{customerId}")
    public BaseResponseModel<CustomerResponseModel> getCustomer(@PathVariable @Valid String customerId) {

        return service.getCustomer(customerId);
    }

    @GetMapping("/{customerId}")
    public BaseResponseModel<Boolean> findCustomer(@PathVariable @Valid String customerId) {

        return service.findCustomer(customerId);
    }

    @DeleteMapping("/{customerId}")
    public BaseResponseModel<CustomerResponseModel> deleteCustomer(@PathVariable @Valid String customerId) {

        return service.deleteCustomer(customerId);
    }
}
