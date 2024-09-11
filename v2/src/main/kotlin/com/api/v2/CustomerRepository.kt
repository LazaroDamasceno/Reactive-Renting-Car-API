package com.api.v2

import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import java.util.UUID

interface CustomerRepository: CoroutineCrudRepository<Customer, UUID> {

}