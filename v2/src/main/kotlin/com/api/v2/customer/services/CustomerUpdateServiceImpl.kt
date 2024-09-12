package com.api.v2.customer.services

import com.api.v2.customer.domain.CustomerRepository
import com.api.v2.customer.dtos.CustomerResponseDto
import com.api.v2.customer.dtos.CustomerUpdateRequestDto
import com.api.v2.customer.mappers.CustomerResponseMapper
import com.api.v2.customer.utils.CustomerFinderUtil
import jakarta.validation.Valid
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
private class CustomerUpdateServiceImpl: CustomerUpdateService {

    @Autowired
    private lateinit var customerRepository: CustomerRepository

    @Autowired
    private lateinit var customerFinderUtil: CustomerFinderUtil

    override suspend fun update(ssn: String, requestDto: @Valid CustomerUpdateRequestDto): CustomerResponseDto {
        return withContext(Dispatchers.IO) {
            val customer = customerFinderUtil.find(ssn)
            customer.update(requestDto)
            val savedCustomer = customerRepository.save(customer)
            CustomerResponseMapper.mapToDto(savedCustomer)
        }
    }

}