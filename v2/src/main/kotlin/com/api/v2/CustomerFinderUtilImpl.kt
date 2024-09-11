package com.api.v2

import kotlinx.coroutines.flow.firstOrNull
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class CustomerFinderUtilImpl: CustomerFinderUtil {

    @Autowired
    private lateinit var customerRepository: CustomerRepository

    override suspend fun find(ssn: String): Customer {
        val customer = customerRepository
            .findAll()
            .firstOrNull()
        if (customer == null) throw CustomerNotFoundException()
        return customer
    }

}