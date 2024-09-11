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
    lateinit var updatedAt: String

    constructor(
        id: UUID,
        createdAt: String,
        phoneNumber: String,
        address: String,
        email: String,
        birthDate: LocalDate,
        ssn: String,
        lastName: String,
        middleName: String,
        firstName: String
    ) {
        this.id = id
        this.createdAt = createdAt
        this.phoneNumber = phoneNumber
        this.address = address
        this.email = email
        this.birthDate = birthDate
        this.ssn = ssn
        this.lastName = lastName
        this.middleName = middleName
        this.firstName = firstName
    }

    fun fullName(): String {
        if (middleName.isEmpty()) return "$firstName $lastName"
        return "$firstName $middleName $lastName"
    }

    fun update(
        phoneNumber: String,
        address: String,
        email: String,
        birthDate: LocalDate,
        lastName: String,
        middleName: String,
        firstName: String
    ) {

        this.phoneNumber = phoneNumber
        this.address = address
        this.email = email
        this.birthDate = birthDate
        this.lastName = lastName
        this.middleName = middleName
        this.firstName = firstName
        this.updatedAt = ZonedDateTime.now().toString()
    }

}