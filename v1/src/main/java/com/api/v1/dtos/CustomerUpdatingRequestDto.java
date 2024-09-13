package com.api.v1.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record CustomerUpdatingRequestDto(
        @NotBlank String firstName,
        String middleName,
        @NotBlank String lastName,
        @NotNull LocalDate birthDate,
        @NotBlank @Email String email,
        @NotBlank String address,
        @NotBlank @Size(min=10, max=10) String phoneNumber
) {
}
