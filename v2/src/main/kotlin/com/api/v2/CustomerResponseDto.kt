package com.api.v2

import java.time.LocalDate

data class CustomerResponseDto(
    val fullName: String,
    val ssn: String,
    val birthDate: LocalDate,
    val phoneNumber: String,
    val address: String,
    val email: String,
    val createdAt: String,
    val updatedAt: String?
)
