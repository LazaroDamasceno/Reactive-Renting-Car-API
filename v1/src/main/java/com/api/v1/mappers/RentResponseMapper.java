package com.api.v1.mappers;

import com.api.v1.domain.Car;
import com.api.v1.domain.Customer;
import com.api.v1.domain.Payment;
import com.api.v1.domain.Rent;
import com.api.v1.dtos.RentResponseDto;

public record RentResponseMapper(
        Rent rent,
        Customer customer,
        Car car,
        Payment payment
) {

    public RentResponseDto map() {
        return new RentResponseDto(
                rent.getOrderNumber(),
                new CustomerResponseMapper(customer).mapToDto(),
                new CarResponseMapper(car).mapToDto(),
                new PaymentResponseMapper(payment, payment.getCreditCard()).map(),
                rent.getRentedAt()
        );
    }

}
