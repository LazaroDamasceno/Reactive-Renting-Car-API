package com.api.v1.dtos;

import java.math.BigInteger;

public record PaymentResponseDto(
        BigInteger orderNumber,
        CustomerResponseDto customer,
        CarResponseDto car,
        CreditCardResponseDto creditCard,
        String paidAt
) {
}
