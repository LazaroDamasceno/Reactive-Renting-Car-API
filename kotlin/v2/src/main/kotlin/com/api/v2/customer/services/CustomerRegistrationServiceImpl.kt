package com.api.v2.customer.services

import com.api.v2.customer.domain.Customer
import com.api.v2.customer.domain.CustomerRepository
import com.api.v2.customer.dtos.CustomerResponseDto
import com.api.v2.customer.exceptions.DuplicatedSsnException
import com.api.v2.customer.mappers.CustomerResponseMapper
import jakarta.validation.Valid
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
private class CustomerRegistrationServiceImpl: CustomerRegistrationService {

    @Autowired
    lateinit var customerRepository: CustomerRepository

    override suspend fun register(requestDto: @Valid Customer): CustomerResponseDto {
        return withContext(Dispatchers.IO) {
            if (checkTheExistenceOfDuplicatedSsn(requestDto.ssn)) {
                throw DuplicatedSsnException(requestDto.ssn)
            }
            val savedCustomer = customerRepository.save(requestDto)
            CustomerResponseMapper.mapToDto(savedCustomer)
        }
    }

    private suspend fun checkTheExistenceOfDuplicatedSsn(ssn: String): Boolean {
        return customerRepository.findAll().firstOrNull { e -> e.ssn == ssn } != null
    }

}