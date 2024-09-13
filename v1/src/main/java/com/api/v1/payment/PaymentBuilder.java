package com.api.v1.payment;

import com.api.v1.car.domain.Car;
import com.api.v1.creditcar.domain.CreditCard;
import com.api.v1.customer.domain.Customer;

import java.time.ZonedDateTime;
import java.util.UUID;

public class PaymentBuilder {

    private final UUID id = UUID.randomUUID();
    private Customer customer;
    private Car car;
    private CreditCard creditCard;
    private String paidAt = ZonedDateTime.now().toString();

    private PaymentBuilder() {}

    public static PaymentBuilder create() {
        return new PaymentBuilder();
    }

    public PaymentBuilder withCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public PaymentBuilder withCar(Car car) {
        this.car = car;
        return this;
    }

    public PaymentBuilder withCustomer(CreditCard creditCard) {
        this.creditCard = creditCard;
        return this;
    }

    public Payment build() {
        return new Payment(
                id,
                customer,
                car,
                creditCard,
                paidAt
        );
    }

}
