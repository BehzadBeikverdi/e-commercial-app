package com.stringwavetech.ecommerce.model.request;

import java.util.UUID;

public record OrderLineRequestModel(

        UUID orderId,
        UUID productId,
        double quantity
) {
}
