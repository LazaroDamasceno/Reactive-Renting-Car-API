package com.api.v2

import java.time.LocalDate
import java.util.*

data class CustomerRegistrationRequestDto(
    val id: UUID,
    val createdAt: String,
    val phoneNumber: String,
    val address: String,
    val email: String,
    val birthDate: LocalDate,
    val ssn: String,
    val lastName: String,
    val middleName: String,
    val firstName: String
)
