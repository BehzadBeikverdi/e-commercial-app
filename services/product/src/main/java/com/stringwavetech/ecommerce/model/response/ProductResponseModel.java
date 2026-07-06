package com.stringwavetech.ecommerce.model.response;

import java.math.BigDecimal;
import java.util.UUID;

public record ProductResponseModel(

        String id,
        String name,
        String description,
        double availableQuantity,
        BigDecimal price,
        String categoryId,
        String categoryName,
        String categoryDescription
) {
}
