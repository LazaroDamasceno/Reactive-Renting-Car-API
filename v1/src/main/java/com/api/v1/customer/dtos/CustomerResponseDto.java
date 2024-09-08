package com.api.v1.customer.dtos;

import java.time.LocalDate;

public record CustomerResponseDto(
        String firstName,
        String middleName,
        String lastName,
        String ssn,
        LocalDate birthDate,
        String email,
        String address,
        String phoneNumber,
        String createdAt,
        String updatedAt
) {
}
