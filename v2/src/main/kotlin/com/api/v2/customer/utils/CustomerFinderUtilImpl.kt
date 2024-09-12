package com.api.v2.customer.utils

import com.api.v2.customer.domain.Customer
import com.api.v2.customer.domain.CustomerRepository
import com.api.v2.customer.exceptions.CustomerNotFoundException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class CustomerFinderUtilImpl: CustomerFinderUtil {

    @Autowired
    private lateinit var customerRepository: CustomerRepository

    override suspend fun find(ssn: String): Customer {
        return withContext(Dispatchers.IO) {
            val customer = customerRepository
                .findAll()
                .firstOrNull()
            if (customer == null) {
                throw CustomerNotFoundException()
            }
            customer
        }
    }

}