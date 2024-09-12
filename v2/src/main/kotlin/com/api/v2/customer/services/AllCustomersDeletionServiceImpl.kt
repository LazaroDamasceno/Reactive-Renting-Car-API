package com.api.v2.customer.services

import com.api.v2.customer.domain.CustomerRepository
import com.api.v2.customer.exceptions.EmptyCustomerEntityException
import com.api.v2.customer.utils.CustomerFinderUtil
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
private class AllCustomersDeletionServiceImpl: AllCustomersDeletionService {

    @Autowired
    lateinit var customerRepository: CustomerRepository

    @Autowired
    lateinit var customerFinderUtil: CustomerFinderUtil

    override suspend fun deleteBySsn(ssn: String) {
        withContext(Dispatchers.IO) {
            val customer = customerFinderUtil.find(ssn)
            customerRepository.delete(customer)
        }
    }

    override suspend fun deleteAll() {
        withContext(Dispatchers.IO) {
            if (checkIfCustomerEntityIsEmpty()) {
                throw EmptyCustomerEntityException()
            }
            customerRepository.deleteAll()
        }
    }

    private suspend fun checkIfCustomerEntityIsEmpty(): Boolean {
        return customerRepository.count() == 0L
    }

}