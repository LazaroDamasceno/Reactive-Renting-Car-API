package com.api.v1.payment;

import com.api.v1.car.dtos.CarResponseDto;
import com.api.v1.creditcar.dtos.CreditCardResponseDto;
import com.api.v1.customer.dtos.CustomerResponseDto;

public record PaymentResponseDto(
        CustomerResponseDto customer,
        CarResponseDto car,
        CreditCardResponseDto creditCard,
        String paidAt
) {
}
