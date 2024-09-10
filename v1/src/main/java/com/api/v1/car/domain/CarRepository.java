package com.api.v1.car.domain;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.UUID;

public interface CarRepository extends ReactiveCrudRepository<Car, UUID> {
}
