package com.api.v2.customer.mappers

import com.api.v2.customer.domain.Customer
import com.api.v2.customer.dtos.CustomerResponseDto

class CustomerResponseMapper {

    companion object {

        fun mapToDto(customer: com.api.v2.customer.domain.Customer): com.api.v2.customer.dtos.CustomerResponseDto {
            return com.api.v2.customer.dtos.CustomerResponseDto(
                customer.fullName(),
                customer.ssn,
                customer.birthDate,
                customer.email,
                customer.phoneNumber,
                customer.gender,
                customer.createdAt
            )
        }

    }

}