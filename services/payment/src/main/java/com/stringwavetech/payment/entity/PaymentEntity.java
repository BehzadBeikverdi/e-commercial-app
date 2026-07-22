package com.stringwavetech.payment.entity;

import com.stringwavetech.payment.enums.PaymentMethodEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity(name = "payment")
@NoArgsConstructor
public class PaymentEntity extends BaseEntity {

    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private PaymentMethodEnum paymentMethod;

    private Integer orderId;

}
