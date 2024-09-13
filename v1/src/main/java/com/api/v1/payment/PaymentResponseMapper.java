package com.api.v1.payment;

import com.api.v1.car.domain.Car;
import com.api.v1.car.mappers.CarResponseMapper;
import com.api.v1.creditcar.domain.CreditCard;
import com.api.v1.creditcar.mappers.CreditCardResponseMapper;
import com.api.v1.customer.domain.Customer;
import com.api.v1.customer.mappers.CustomerResponseMapper;

public record PaymentResponseMapper(
        Customer customer,
        Car car,
        CreditCard creditCard,
        Payment payment
) {

    PaymentResponseDto map() {
        return new PaymentResponseDto(
                new CustomerResponseMapper(customer).mapToDto(),
                new CarResponseMapper(car).mapToDto(),
                new CreditCardResponseMapper(creditCard).mapToDto(),
                payment.getPaidAt()
        );
    }

}
