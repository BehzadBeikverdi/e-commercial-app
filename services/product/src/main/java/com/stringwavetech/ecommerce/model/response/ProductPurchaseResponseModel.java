package com.stringwavetech.ecommerce.model.response;

import java.math.BigDecimal;
import java.util.UUID;

public record ProductPurchaseResponseModel(

        String productId,
        String name,
        String description,
        BigDecimal price,
        double quantity
) {
}
