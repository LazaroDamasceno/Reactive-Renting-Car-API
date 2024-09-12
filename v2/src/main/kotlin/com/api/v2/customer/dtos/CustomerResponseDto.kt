package com.api.v2.customer.dtos

import java.time.LocalDate

data class CustomerResponseDto(
    var fullName: String,
    var ssn: String,
    var birthDate: LocalDate,
    var email: String,
    var phoneNumber: String,
    var gender: String,
    var createdAt: String,
    var updatedAt: String?
)
