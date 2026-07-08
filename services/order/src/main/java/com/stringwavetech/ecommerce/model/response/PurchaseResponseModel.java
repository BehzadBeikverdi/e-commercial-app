package com.stringwavetech.ecommerce.model.response;

import java.math.BigDecimal;

public record PurchaseResponseModel(

        String productId,
        String name,
        String description,
        BigDecimal price,
        double quantity
) {
}
