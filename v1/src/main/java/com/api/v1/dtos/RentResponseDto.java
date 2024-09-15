package com.api.v1.dtos;

import java.math.BigInteger;

public record RentResponseDto(
        BigInteger orderNumber,
        CustomerResponseDto customer,
        CarResponseDto car,
        PaymentResponseDto payment,
        String rentedAt
) {
}
