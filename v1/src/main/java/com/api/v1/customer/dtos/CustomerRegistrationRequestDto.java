package com.api.v1.customer.dtos;

public record CustomerRegistrationRequestDto(
        String firstName,
        String middleName,
        String lastName,
        String ssn,
        LocalDate birthDate,
        String email,
        String address,
        String phoneNumber
) {
}
