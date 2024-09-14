package com.api.v1.mappers;

import com.api.v1.domain.Car;
import com.api.v1.domain.CreditCard;
import com.api.v1.domain.Customer;
import com.api.v1.domain.Payment;
import com.api.v1.dtos.PaymentResponseDto;

public record PaymentResponseMapper(
        Payment payment,
        Customer customer,
        Car car,
        CreditCard creditCard
) {

    public PaymentResponseDto map() {
        return new PaymentResponseDto(
                payment.getOrderNumber(),
                new CustomerResponseMapper(customer).mapToDto(),
                new CarResponseMapper(car).mapToDto(),
                new CreditCardResponseMapper(creditCard).mapToDto(),
                payment.getPaidAt()
        );
    }

}
