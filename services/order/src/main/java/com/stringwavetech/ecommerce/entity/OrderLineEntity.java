package com.stringwavetech.ecommerce.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import org.hibernate.query.Order;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity(name = BaseEntity.PREFIX + "order_line")
public class OrderLineEntity extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;
    private UUID productId;
    private double quantity;
}