package com.api.v1.dtos.payment;

import com.api.v1.dtos.creditcard.CreditCardResponseDto;

import java.math.BigInteger;

public record PaymentResponseDto(
        BigInteger orderNumber,
        CreditCardResponseDto creditCard,
        String paidAt
) {
}
