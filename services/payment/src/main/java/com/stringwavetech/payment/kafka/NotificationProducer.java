package com.stringwavetech.payment.kafka;

import com.stringwavetech.payment.model.PaymentNotification;

public interface NotificationProducer {

    void sendNotification(PaymentNotification request);
}
