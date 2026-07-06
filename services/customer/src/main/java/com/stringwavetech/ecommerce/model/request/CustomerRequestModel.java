package com.stringwavetech.ecommerce.model.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CustomerRequestModel(

        @NotBlank(message = "Firstname is required")
        String firstname,

        @NotBlank(message = "Lastname is required")
        String lastname,

        @NotBlank(message = "Email is required")
        @Email(message = "Email should be valid")
        String email,

        @NotNull(message = "Address is required")
        @Valid AddressModel address
) {

    public record AddressModel(

            @NotBlank(message = "Street is required")
            String street,

            @NotBlank(message = "House number is required")
            String houseNumber,

            @NotBlank(message = "Zip code is required")
            String zipCode
    ) {
    }
}