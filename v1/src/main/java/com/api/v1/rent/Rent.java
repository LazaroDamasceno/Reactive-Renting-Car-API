package com.api.v1.rent;

import com.api.v1.car.domain.Car;
import com.api.v1.customer.domain.Customer;
import com.api.v1.payment.Payment;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Document(collection = "v1_rents")
public class Rent {

    @Id
    private final UUID id;

    @Field
    private final Car car;

    @Field
    private final Customer customer;

    @Field
    private final Payment payment;

    @Field
    private final String rentedAt;

    @Field
    private final String dueDate;

    @Field
    private String returningDate;

    public Rent(
            UUID id,
            Car car,
            Customer customer,
            Payment payment,
            String createdAt,
            String dueDate
    ) {
        this.id = id;
        this.car = car;
        this.customer = customer;
        this.payment = payment;
        this.rentedAt = createdAt;
        this.dueDate = dueDate;
    }

    public void markAsFinished() {
        this.returningDate = ZonedDateTime.now().toString();
    }

}
