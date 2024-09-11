package com.api.v2

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CustomerUpdateServiceImpl: CustomerUpdateService {

    @Autowired
    private lateinit var customerRepository: CustomerRepository

    @Autowired
    private lateinit var customerFinderUtil: CustomerFinderUtil

    override suspend fun update(ssn: String, requestDto: CustomerUpdateRequestDto): CustomerResponseDto {
        return withContext(Dispatchers.IO) {
            val customer = customerFinderUtil.find(ssn)
            customer.update(requestDto)
            val savedCustomer = customerRepository.save(customer)
            CustomerResponseMapper.mapToDto(savedCustomer)
        }
    }

}