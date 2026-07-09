package com.stringwavetech.ecommerce.entity;

import com.stringwavetech.ecommerce.enums.PaymentMethodEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import static jakarta.persistence.EnumType.STRING;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity(name = BaseEntity.PREFIX + "order")
public class OrderEntity extends BaseEntity {

    private String reference;
    private BigDecimal totalAmount;
    @Enumerated(STRING)
    private PaymentMethodEnum paymentMethod;
    private UUID customerId;
    @OneToMany(mappedBy = "order")
    private List<OrderLineEntity> orderLines;
}
