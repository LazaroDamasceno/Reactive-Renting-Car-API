package com.api.v2.customer.utils

import com.api.v2.customer.exceptions.CustomerNotFoundException
import com.api.v2.customer.domain.Customer
import com.api.v2.customer.domain.CustomerRepository
import kotlinx.coroutines.flow.firstOrNull
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class CustomerFinderUtilImpl: com.api.v2.customer.utils.CustomerFinderUtil {

    @Autowired
    private lateinit var customerRepository: com.api.v2.customer.domain.CustomerRepository

    override suspend fun find(ssn: String): com.api.v2.customer.domain.Customer {
        val customer = customerRepository
            .findAll()
            .firstOrNull()
        if (customer == null) throw com.api.v2.customer.exceptions.CustomerNotFoundException()
        return customer
    }

}