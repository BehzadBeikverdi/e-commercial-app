package com.stringwavetech.ecommerce.repository;

import com.stringwavetech.ecommerce.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<OrderEntity, UUID> {
}
