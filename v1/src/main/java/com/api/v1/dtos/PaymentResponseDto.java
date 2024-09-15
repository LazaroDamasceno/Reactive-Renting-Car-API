package com.api.v1.dtos;

import java.math.BigInteger;

public record PaymentResponseDto(
        BigInteger orderNumber,
        CreditCardResponseDto creditCard,
        String paidAt
) {
}
