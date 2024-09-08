package com.api.v1.customer.builders;

import com.api.v1.customer.domain.Customer;
import com.api.v1.customer.dtos.CustomerRegistrationRequestDto;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.UUID;

public class CustomerBuilder {

    private final UUID id = UUID.randomUUID();
    private String firstName;
    private String middleName;
    private String lastName;
    private String ssn;
    private LocalDate birthDate;
    private String email;
    private String address;
    private String phoneNumber;
    private final String createdAt = ZonedDateTime.now().toString();

    private CustomerBuilder() {}

    public static CustomerBuilder create() {
        return new CustomerBuilder();
    }

    public CustomerBuilder fromDto(CustomerRegistrationRequestDto request) {
        this.firstName = request.firstName();
        this.middleName = request.middleName();
        this.lastName = request.lastName();
        this.ssn = request.ssn();
        this.birthDate = request.birthDate();
        this.email = request.email();
        this.address = request.address();
        this.phoneNumber = request.phoneNumber();
        return this;
    }

    public Customer build() {
        return new Customer(
                id,
                firstName,
                middleName,
                lastName,
                ssn,
                birthDate,
                email,
                address,
                phoneNumber,
                createdAt
        );
    }

}
