package com.stringwavetech.ecommerce.client;

import com.stringwavetech.ecommerce.model.request.PurchaseRequestModel;
import com.stringwavetech.ecommerce.model.response.PurchaseResponseModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(
        name = "product-service",
        url = "${application.config.product-url}"
)
public interface ProductClient {

    @PostMapping(
            value = "/purchase"
    )
    List<PurchaseResponseModel> purchaseProducts(
            @RequestBody List<PurchaseRequestModel> requestBody
    );
}
