package com.api.v2

import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDate
import java.time.ZonedDateTime
import java.util.*

@Document(collection = "v1_customers")
class Customer {

    val id: UUID
    var firstName: String
    var middleName: String
    var lastName: String
    var ssn: String
    var birthDate: LocalDate
    var email: String
    var address: String
    var phoneNumber: String
    val createdAt: String
    var updatedAt: String? = null

    constructor(
        id: UUID,
        firstName: String,
        middleName: String,
        lastName: String,
        ssn: String,
        birthDate: LocalDate,
        email: String,
        address: String,
        phoneNumber: String,
        createdAt: String
    ) {
        this.id = id
        this.firstName = firstName
        this.middleName = middleName
        this.lastName = lastName
        this.ssn = ssn
        this.birthDate = birthDate
        this.email = email
        this.address = address
        this.phoneNumber = phoneNumber
        this.createdAt = createdAt
    }


    fun fullName(): String {
        if (middleName.isEmpty()) return "$firstName $lastName"
        return "$firstName $middleName $lastName"
    }

}