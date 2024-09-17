package com.api.v1.mappers.payment;

import com.api.v1.domain.creditcard.CreditCard;
import com.api.v1.domain.payment.Payment;
import com.api.v1.dtos.payment.PaymentResponseDto;
import com.api.v1.mappers.creditcard.CreditCardResponseMapper;

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
