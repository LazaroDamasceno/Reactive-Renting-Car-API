package com.api.v2.rent;

import com.api.v2.car.domain.Car;
import com.api.v2.customer.domain.Customer;
import com.api.v2.payment.Payment;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.ZonedDateTime;
import java.util.UUID;

@Document(collection = "v1_rents")
public class Rent {

    private final UUID id;

    private final Car car;

    private final Customer customer;

    private final Payment payment;

    private final String rentedAt;

    private final String dueDate;

    private String returnedAt;

    public Rent(
            UUID id,
            Car car,
            Customer customer,
            Payment payment,
            String rentedAt,
            String dueDate
    ) {
        this.id = id;
        this.car = car;
        this.customer = customer;
        this.payment = payment;
        this.rentedAt = rentedAt;
        this.dueDate = dueDate;
    }

    public void markAsReturned() {
        returnedAt = ZonedDateTime.now().toString();
    }

}
