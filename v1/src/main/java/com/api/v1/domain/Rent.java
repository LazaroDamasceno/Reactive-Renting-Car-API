package com.api.v1.domain;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigInteger;
import java.util.UUID;

@Getter
@Document(collection = "v1_rents")
public class Rent {

    @Id
    private UUID id;

    @Field
    private BigInteger orderNumber;

    @Field
    private Customer customer;

    @Field
    private Car car;

    @Field
    private Payment payment;

    @Field
    private String rentedAt;

    public Rent(
            UUID id,
            BigInteger orderNumber,
            Customer customer,
            Car car,
            Payment payment,
            String rentedAt) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.customer = customer;
        this.car = car;
        this.payment = payment;
        this.rentedAt = rentedAt;
    }

}
