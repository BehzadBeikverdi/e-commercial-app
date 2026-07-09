package com.stringwavetech.ecommerce.repository;

import com.stringwavetech.ecommerce.entity.OrderLineEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface OrderLineRepository extends JpaRepository<OrderLineEntity, UUID> {

    List<OrderLineEntity> findAllByOrderId(UUID orderId);
}
