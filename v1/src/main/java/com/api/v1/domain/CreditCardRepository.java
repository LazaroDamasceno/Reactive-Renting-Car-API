package com.api.v1.domain;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.UUID;

public interface CreditCardRepository extends ReactiveCrudRepository<CreditCard, UUID> {
}
