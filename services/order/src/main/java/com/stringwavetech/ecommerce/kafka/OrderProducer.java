package com.stringwavetech.ecommerce.kafka;

import com.stringwavetech.ecommerce.model.OrderConfirmation;

public interface OrderProducer {

    void sendOrderConfirmation(OrderConfirmation orderConfirmation);
}
