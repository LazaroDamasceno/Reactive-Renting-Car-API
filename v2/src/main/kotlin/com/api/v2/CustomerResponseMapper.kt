package com.api.v2

import reactor.core.publisher.Mono

class CustomerResponseMapper {

    companion object {

        fun mapToMono(customer: Customer): Mono<CustomerResponseDto> {
            return Mono.just(mapToDto(customer))
        }

        private fun mapToDto(customer: Customer): CustomerResponseDto {
            return CustomerResponseDto(
                customer.fullName(),
                customer.ssn,
                customer.birthDate,
                customer.phoneNumber,
                customer.address,
                customer.email,
                customer.createdAt,
                customer.updatedAt
            )
        }

    }

}