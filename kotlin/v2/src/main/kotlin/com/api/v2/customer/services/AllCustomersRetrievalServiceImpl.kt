package com.api.v2.customer.services

import com.api.v2.customer.domain.CustomerRepository
import com.api.v2.customer.dtos.CustomerResponseDto
import com.api.v2.customer.exceptions.EmptyCustomerEntityException
import com.api.v2.customer.mappers.CustomerResponseMapper
import com.api.v2.customer.utils.CustomerFinderUtil
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
private class AllCustomersRetrievalServiceImpl: AllCustomersRetrievalService {

    @Autowired
    lateinit var customerFinderUtil: CustomerFinderUtil

    @Autowired
    lateinit var customerRepository: CustomerRepository

    override suspend fun findBySsn(ssn: String): CustomerResponseDto {
        return withContext(Dispatchers.IO) {
            val customer = customerFinderUtil.find(ssn)
            CustomerResponseMapper.mapToDto(customer)
        }
    }

    override suspend fun findAll(): Flow<CustomerResponseDto> {
        return withContext(Dispatchers.IO) {
            if (checkIfCustomerEntityIsEmpty()) {
                throw EmptyCustomerEntityException()
            }
            customerRepository.findAll().map { customer -> CustomerResponseMapper.mapToDto(customer) }
        }
    }

    suspend fun checkIfCustomerEntityIsEmpty(): Boolean {
        return customerRepository.count() == 0L
    }

}