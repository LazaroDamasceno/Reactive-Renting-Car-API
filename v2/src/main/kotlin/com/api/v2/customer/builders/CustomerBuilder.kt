package com.api.v2.customer.builders

import com.api.v2.dtos.CustomerRegistrationRequestDto
import com.api.v2.customer.domain.Customer
import java.time.LocalDate
import java.time.ZonedDateTime
import java.util.UUID

class CustomerBuilder {

    private val id: UUID = UUID.randomUUID()
    private lateinit var firstName: String
    private lateinit var middleName: String
    private lateinit var lastName: String
    private lateinit var ssn: String
    private lateinit var birthDate: LocalDate
    private lateinit var email: String
    private lateinit var phoneNumber: String
    private lateinit var gender: String
    private val createdAt = ZonedDateTime.now().toString()

    companion object {
        fun create(): CustomerBuilder {
            return CustomerBuilder()
        }
    }

    fun fromDto(requestDto: CustomerRegistrationRequestDto): CustomerBuilder {
        firstName = requestDto.firstName
        middleName = requestDto.middleName
        lastName = requestDto.lastName
        ssn = requestDto.ssn
        birthDate = requestDto.birthDate
        email = requestDto.email
        phoneNumber = requestDto.phoneNumber
        gender = requestDto.gender
        return this
    }

    fun build(): com.api.v2.customer.domain.Customer {
        return com.api.v2.customer.domain.Customer(
            id,
            firstName,
            middleName,
            lastName,
            ssn,
            birthDate,
            email,
            phoneNumber,
            gender,
            createdAt
        )
    }

}