package com.api.v1.mappers.rent;

import com.api.v1.domain.car.Car;
import com.api.v1.domain.customer.Customer;
import com.api.v1.domain.payment.Payment;
import com.api.v1.domain.rent.Rent;
import com.api.v1.dtos.rent.RentResponseDto;
import com.api.v1.mappers.customer.CustomerResponseMapper;
import com.api.v1.mappers.payment.PaymentResponseMapper;
import com.api.v1.mappers.car.CarResponseMapper;

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
                rent.getDays(),
                rent.getPrice(),
                rent.getReturningDate(),
                rent.getReturnedAt(),
                rent.getRentedAt()
        );
    }

}
