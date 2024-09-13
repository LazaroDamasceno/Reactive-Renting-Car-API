package com.api.v1.dtos;

public record PaymentResponseDto(
        CustomerResponseDto customer,
        CarResponseDto car,
        CreditCardResponseDto creditCard,
        String paidAt
) {
}
