package com.api.v1.customer.domain;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.UUID;

public interface CustomerRepository extends ReactiveCrudRepository<Customer, UUID> {
}
