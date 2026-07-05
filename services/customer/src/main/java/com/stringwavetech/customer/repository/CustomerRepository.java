package com.stringwavetech.customer.repository;

import com.stringwavetech.customer.entity.CustomerDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface CustomerRepository extends MongoRepository<CustomerDocument, UUID> {
}
