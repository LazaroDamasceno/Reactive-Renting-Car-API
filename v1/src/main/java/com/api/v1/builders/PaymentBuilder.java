package com.api.v1.builders;

import com.api.v1.domain.Car;
import com.api.v1.domain.CreditCard;
import com.api.v1.domain.Customer;
import com.api.v1.domain.Payment;
import com.api.v1.utils.PaymentOrderNumberGeneratorUtil;

import java.math.BigInteger;
import java.time.ZonedDateTime;
import java.util.UUID;

public class PaymentBuilder {

    private final UUID id = UUID.randomUUID();
    private final BigInteger orderNumber = PaymentOrderNumberGeneratorUtil.generate();
    private Customer customer;
    private Car car;
    private CreditCard creditCard;
    private final String paidAt = ZonedDateTime.now().toString();

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
                orderNumber,
                customer,
                car,
                creditCard,
                paidAt
        );
    }

}
