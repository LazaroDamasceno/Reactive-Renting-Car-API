package com.api.v1.dtos;

import java.math.BigDecimal;
import java.math.BigInteger;

public record RentResponseDto(
        BigInteger orderNumber,
        CustomerResponseDto customer,
        CarResponseDto car,
        PaymentResponseDto payment,
        int days,
        BigDecimal price,
        String returningDate,
        String returnedAt,
        String rentedAt
) {
}
