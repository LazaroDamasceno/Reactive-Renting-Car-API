package com.api.v2.customer.services

import com.api.v2.customer.builders.CustomerBuilder
import com.api.v2.customer.dtos.CustomerRegistrationRequestDto
import jakarta.validation.Valid
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CustomerRegistrationServiceImpl: CustomerRegistrationService {

    @Autowired
    private lateinit var customerRepository: com.api.v2.customer.domain.CustomerRepository

    override suspend fun register(requestDto: @Valid CustomerRegistrationRequestDto): com.api.v2.customer.dtos.CustomerResponseDto {
        return withContext(Dispatchers.IO) {
            if (checkTheExistenceOfDuplicatedSsn(requestDto.ssn)) {
                throw com.api.v2.customer.exceptions.DuplicatedSsnException(requestDto.ssn)
            }
            val newCustomer = CustomerBuilder.create().fromDto(requestDto).build()
            val savedCustomer = customerRepository.save(newCustomer)
            com.api.v2.customer.mappers.CustomerResponseMapper.mapToDto(savedCustomer)
        }
    }

    private suspend fun checkTheExistenceOfDuplicatedSsn(ssn: String): Boolean {
        return customerRepository.findAll().firstOrNull { e -> e.ssn == ssn } != null
    }

}