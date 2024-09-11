package com.api.v2

import java.time.LocalDate
import java.util.*

data class CustomerUpdatingRequestDto(
    val phoneNumber: String,
    val address: String,
    val email: String,
    val birthDate: LocalDate,
    val lastName: String,
    val middleName: String,
    val firstName: String
)
