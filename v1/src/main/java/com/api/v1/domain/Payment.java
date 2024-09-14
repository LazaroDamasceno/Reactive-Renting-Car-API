package com.api.v1.domain;

import java.math.BigInteger;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;

@Getter
@Document(collection = "v1_payments")
public class Payment {

    @Id
    private UUID id;

    @Field
    private BigInteger orderNumber;

    @Field
    private Customer customer;

    @Field
    private Car car;

    @Field
    private CreditCard creditCard;

    @Field
    private String paidAt;

    public Payment(
            UUID id,
            BigInteger orderNumber,
            Customer customer,
            Car car,
            CreditCard creditCard,
            String paidAt
    ) {
        this.id = id;
        this.customer = customer;
        this.orderNumber = orderNumber;
        this.car = car;
        this.creditCard = creditCard;
        this.paidAt = paidAt;
    }

}
