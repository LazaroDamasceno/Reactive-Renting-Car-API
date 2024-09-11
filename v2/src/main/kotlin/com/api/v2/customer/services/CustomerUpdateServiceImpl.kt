package com.api.v2.customer.services

import com.api.v2.customer.dtos.CustomerUpdateRequestDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CustomerUpdateServiceImpl: com.api.v2.customer.services.CustomerUpdateService {

    @Autowired
    private lateinit var customerRepository: com.api.v2.customer.domain.CustomerRepository

    @Autowired
    private lateinit var customerFinderUtil: com.api.v2.customer.utils.CustomerFinderUtil

    override suspend fun update(ssn: String, requestDto: CustomerUpdateRequestDto): com.api.v2.customer.dtos.CustomerResponseDto {
        return withContext(Dispatchers.IO) {
            val customer = customerFinderUtil.find(ssn)
            customer.update(requestDto)
            val savedCustomer = customerRepository.save(customer)
            com.api.v2.customer.mappers.CustomerResponseMapper.mapToDto(savedCustomer)
        }
    }

}