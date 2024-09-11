package com.api.v2

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDate
import java.util.UUID

@Document(collection = "v1_customers")
class Customer(
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
    val createdAt: String
) {

    lateinit var updatedAt: String

    fun fullName(): String {
        if (middleName.isEmpty()) {
            return "$firstName $lastName"
        }
        return "$firstName $middleName $lastName"
    }

}