package com.api.v1.mappers;

import com.api.v1.domain.Car;
import com.api.v1.domain.Payment;
import com.api.v1.dtos.PaymentResponseDto;
import com.api.v1.domain.CreditCard;
import com.api.v1.domain.Customer;

import java.math.BigInteger;

public record PaymentResponseMapper(
        BigInteger orderNumber,
        Customer customer,
        Car car,
        CreditCard creditCard,
        Payment payment
) {

    PaymentResponseDto map() {
        return new PaymentResponseDto(
                orderNumber,
                new CustomerResponseMapper(customer).mapToDto(),
                new CarResponseMapper(car).mapToDto(),
                new CreditCardResponseMapper(creditCard).mapToDto(),
                payment.getPaidAt()
        );
    }

}
