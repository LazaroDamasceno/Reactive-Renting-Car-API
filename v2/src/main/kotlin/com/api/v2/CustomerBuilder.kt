package com.api.v2

import jakarta.validation.Valid
import java.time.LocalDate
import java.time.ZonedDateTime
import java.util.*

class CustomerBuilder {

    private val id = UUID.randomUUID()
    private lateinit var firstName: String
    private lateinit var middleName: String
    private lateinit var lastName: String
    private lateinit var ssn: String
    private lateinit var birthDate: LocalDate
    private lateinit var email: String
    private lateinit var address: String
    private lateinit var phoneNumber: String
    private val createdAt = ZonedDateTime.now().toString()

    companion object {
        fun create(): CustomerBuilder {
            return CustomerBuilder()
        }
    }

    fun fromDto(@Valid requestDto: CustomerRegistrationRequestDto): CustomerBuilder {
        this.firstName = requestDto.firstName
        this.middleName = requestDto.middleName
        this.lastName = requestDto.lastName
        this.ssn = requestDto.ssn
        this.birthDate = requestDto.birthDate
        this.email = requestDto.email
        this.address = requestDto.address
        this.phoneNumber = requestDto.phoneNumber
        return this
    }

    fun build(): Customer {
        return Customer(
            id,
            firstName,
            middleName,
            lastName,
            ssn,
            LocalDate.parse("2000-12-12"),
            email,
            address,
            phoneNumber,
            createdAt
        )
    }
    
}