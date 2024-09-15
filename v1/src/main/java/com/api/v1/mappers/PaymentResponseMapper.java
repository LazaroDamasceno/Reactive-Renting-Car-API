package com.api.v1.mappers;

import com.api.v1.domain.Car;
import com.api.v1.domain.CreditCard;
import com.api.v1.domain.Customer;
import com.api.v1.domain.Payment;
import com.api.v1.dtos.PaymentResponseDto;

public record PaymentResponseMapper(
        Payment payment,
        CreditCard creditCard
) {

    public PaymentResponseDto map() {
        return new PaymentResponseDto(
                payment.getOrderNumber(),
                new CreditCardResponseMapper(creditCard).mapToDto(),
                payment.getPaidAt()
        );
    }

}
