package com.api.v2

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class CustomerRegistrationServiceImpl: CustomerRegistrationService {

    @Autowired
    lateinit var customerRepository: CustomerRepository

    override suspend fun register(requestDto: CustomerRegistrationRequestDto): Mono<CustomerResponseDto> {
        val customer = CustomerBuilder.create().fromDto(requestDto).build()
        withContext(Dispatchers.IO) {
            customerRepository
                .findAll()
                .filter{ e -> e.ssn == requestDto.ssn }
                .hasElements()
                .flatMap { exists ->
                    if (exists) {
                        Mono.error<Throwable>(DuplicatedSsnException(requestDto.ssn))
                    }
                    customerRepository.save(customer)
                }
        }
        return CustomerResponseMapper.mapToMono(customer)
    }

}