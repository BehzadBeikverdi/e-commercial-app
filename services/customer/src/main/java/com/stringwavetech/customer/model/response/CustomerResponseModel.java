package com.stringwavetech.customer.model.response;

public record CustomerResponseModel(

        String id,
        String firstname,

        String lastname,

        String email,

        AddressModel address
) {

    public record AddressModel(

            String street,

            String houseNumber,

            String zipCode
    ) {
    }
}
