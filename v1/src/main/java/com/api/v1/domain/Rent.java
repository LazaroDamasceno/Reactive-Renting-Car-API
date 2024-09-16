package com.api.v1.domain;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.ZonedDateTime;
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
    private int days;

    @Field
    private BigDecimal price;

    @Field
    private String returningDate;

    @Field
    private String returnedAt;

    @Field
    private String rentedAt;

    public Rent(
            UUID id,
            BigInteger orderNumber,
            Customer customer,
            Car car,
            Payment payment,
            int days,
            BigDecimal price,
            String returningDate,
            String rentedAt
    ) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.customer = customer;
        this.car = car;
        this.payment = payment;
        this.days = days;
        this.price = price;
        this.returningDate = returningDate;
        this.rentedAt = rentedAt;
    }

    public void terminate() {
        this.returnedAt = ZonedDateTime.now().toString();
    }

}
