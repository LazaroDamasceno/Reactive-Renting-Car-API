package com.api.v1.dtos.rent;

import com.api.v1.dtos.payment.PaymentResponseDto;
import com.api.v1.dtos.car.CarResponseDto;
import com.api.v1.dtos.customer.CustomerResponseDto;

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
