package com.api.v1.payment;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.UUID;

public interface PaymentRepository extends ReactiveCrudRepository<Payment, UUID> {
}
