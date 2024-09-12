package com.api.v2.car.domain

import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import java.util.UUID

interface CarRepository: CoroutineCrudRepository<Car, UUID>