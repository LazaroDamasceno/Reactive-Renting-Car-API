package com.api.v2.customer.dtos

import java.time.LocalDate

data class CustomerUpdateRequestDto(
    var firstName: String,
    var middleName: String,
    var lastName: String,
    var birthDate: LocalDate,
    var email: String,
    var phoneNumber: String,
    var gender: String,
)