package com.stringwavetech.customer.controller;

import com.stringwavetech.customer.model.request.CustomerRequestModel;
import com.stringwavetech.customer.model.response.CustomerResponseModel;
import com.stringwavetech.customer.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import com.stringwavetech.customer.model.BaseResponseModel;
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

    @DeleteMapping("/{customerId}")
    public BaseResponseModel<CustomerResponseModel> deleteCustomer(@PathVariable @Valid String customerId) {

        return service.deleteCustomer(customerId);
    }
}
