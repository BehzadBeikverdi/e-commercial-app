package com.stringwavetech.ecommerce.model.response;

import java.util.UUID;

public record OrderLineResponseModel(

        UUID id,
        double quantity
) {
}
