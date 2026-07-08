package com.stringwavetech.ecommerce.model.response;

public record CustomerResponseModel(

        String id,
        String firstname,
        String lastname,
        String email
) {
}