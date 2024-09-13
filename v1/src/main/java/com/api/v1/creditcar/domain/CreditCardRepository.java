package com.api.v1.creditcar.domain;

import org.bson.types.ObjectId;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CreditCardRepository extends ReactiveCrudRepository<CreditCard, ObjectId> {
}
