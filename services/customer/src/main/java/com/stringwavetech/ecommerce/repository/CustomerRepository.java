package com.stringwavetech.ecommerce.repository;

import com.stringwavetech.ecommerce.document.CustomerDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface CustomerRepository extends MongoRepository<CustomerDocument, UUID> {
}
