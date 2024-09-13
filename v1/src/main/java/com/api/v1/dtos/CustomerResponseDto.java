package com.api.v1.dtos;

import java.time.LocalDate;

public record CustomerResponseDto(
        String fullName,
        String ssn,
        LocalDate birthDate,
        String email,
        String address,
        String phoneNumber,
        String createdAt,
        String updatedAt
) {
}
