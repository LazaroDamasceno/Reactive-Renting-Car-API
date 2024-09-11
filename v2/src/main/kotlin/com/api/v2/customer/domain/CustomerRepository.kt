package com.api.v2.customer.domain

import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import java.util.UUID

interface CustomerRepository: CoroutineCrudRepository<com.api.v2.customer.domain.Customer, UUID> {

}