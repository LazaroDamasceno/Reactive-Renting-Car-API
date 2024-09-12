package com.api.v2.customer.services

import com.api.v2.customer.dtos.CustomerUpdateRequestDto
import jakarta.validation.Valid
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
private class CustomerUpdateServiceImpl: CustomerUpdateService {

    @Autowired
    private lateinit var customerRepository: com.api.v2.customer.domain.CustomerRepository

    @Autowired
    private lateinit var customerFinderUtil: com.api.v2.customer.utils.CustomerFinderUtil

    override suspend fun update(
        ssn: String,
        requestDto: @Valid CustomerUpdateRequestDto
    ): com.api.v2.customer.dtos.CustomerResponseDto {
        return withContext(Dispatchers.IO) {
            val customer = customerFinderUtil.find(ssn)
            customer.update(requestDto)
            val savedCustomer = customerRepository.save(customer)
            com.api.v2.customer.mappers.CustomerResponseMapper.mapToDto(savedCustomer)
        }
    }

}