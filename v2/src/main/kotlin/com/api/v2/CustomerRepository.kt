package com.api.v2

import org.springframework.data.repository.reactive.ReactiveCrudRepository
import java.util.UUID

interface CustomerRepository: ReactiveCrudRepository<Customer, UUID>