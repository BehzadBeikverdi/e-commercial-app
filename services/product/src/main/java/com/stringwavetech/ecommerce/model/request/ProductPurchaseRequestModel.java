package com.stringwavetech.ecommerce.model.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.UUID;

public record ProductPurchaseRequestModel(

        @NotNull(message = "Product is mandatory")
        String productId,
        @Positive(message = "Quantity is mandatory")
        double quantity
) {
}
