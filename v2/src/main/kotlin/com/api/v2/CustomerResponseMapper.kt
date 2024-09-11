package com.api.v2

class CustomerResponseMapper {

    companion object {

        fun mapToDto(customer: Customer): CustomerResponseDto {
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