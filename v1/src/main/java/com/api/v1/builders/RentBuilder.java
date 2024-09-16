package com.api.v1.builders;

import com.api.v1.domain.Car;
import com.api.v1.domain.Customer;
import com.api.v1.domain.Payment;
import com.api.v1.domain.Rent;
import com.api.v1.utils.RentOrderNumberGeneratorUtil;
import com.api.v1.utils.RentPriceSetterUtil;

import java.math.BigInteger;
import java.time.ZonedDateTime;
import java.util.UUID;

public class RentBuilder {

    private final UUID id = UUID.randomUUID();
    private final BigInteger orderNumber = RentOrderNumberGeneratorUtil.generate();
    private Customer customer;
    private Car car;
    private Payment payment;
    private int days;
    private final String rentedAt = ZonedDateTime.now().toString();

    private RentBuilder() {}

    public static RentBuilder create() {
        return new RentBuilder();
    }

    public RentBuilder withCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public RentBuilder withCar(Car car) {
        this.car = car;
        return this;
    }

    public RentBuilder withPayment(Payment payment) {
        this.payment = payment;
        return this;
    }

    public RentBuilder withDays(int days) {
        this.days = days;
        return this;
    }

    public Rent build() {
        return new Rent(
                id,
                orderNumber,
                customer,
                car,
                payment,
                days,
                RentPriceSetterUtil.set(days),
                ZonedDateTime.now().plusDays(days).toString(),
                ZonedDateTime.now().toString()
        );
    }

}
