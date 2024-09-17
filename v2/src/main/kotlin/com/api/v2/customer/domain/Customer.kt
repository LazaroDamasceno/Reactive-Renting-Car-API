package com.api.v2.customer.domain

import com.api.v2.customer.dtos.CustomerUpdateRequestDto
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDate
import java.time.ZonedDateTime
import java.util.UUID

@Document(collection = "v2_customers")
data class Customer(
    @Id
    val id: UUID,
    var firstName: String,
    var middleName: String,
    var lastName: String,
    var ssn: String,
    var birthDate: LocalDate,
    var email: String,
    var phoneNumber: String,
    var gender: String,
    val createdAt: String,
    var updatedAt: String?
) {

    constructor(
        firstName: String,
        middleName: String,
        lastName: String,
        ssn: String,
        birthDate: LocalDate,
        email: String,
        phoneNumber: String,
        gender: String
    ): this(
        UUID.randomUUID(),
        firstName,
        middleName,
        lastName,
        ssn,
        birthDate,
        email,
        phoneNumber,
        gender,
        ZonedDateTime.now().toString(),
        null
    )

    fun fullName(): String {
        if (middleName.isEmpty()) {
            return "$firstName $lastName"
        }
        return "$firstName $middleName $lastName"
    }

    fun update(requestDto: CustomerUpdateRequestDto): Customer {
        firstName = requestDto.firstName
        middleName = requestDto.middleName
        lastName = requestDto.lastName
        birthDate = requestDto.birthDate
        email = requestDto.email
        phoneNumber = requestDto.phoneNumber
        gender = requestDto.gender
        updatedAt = ZonedDateTime.now().toString()
        return this
    }

}