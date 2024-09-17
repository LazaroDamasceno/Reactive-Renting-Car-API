package com.api.v1.domain.customer;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.api.v1.dtos.customer.CustomerUpdatingRequestDto;

import lombok.Getter;

@Getter
@Document(collection = "v1_customers")
public class Customer {

    @Id
    private UUID id;

    @Field
    private String firstName;

    @Field
    private String middleName;

    @Field
    private String lastName;

    @Field
    private String ssn;

    @Field
    private LocalDate birthDate;

    @Field
    private String email;

    @Field
    private String address;

    @Field
    private String phoneNumber;

    @Field
    private String createdAt;

    @Field
    private String updatedAt;

    public Customer(
            UUID id,
            String firstName,
            String middleName,
            String lastName,
            String ssn,
            LocalDate birthDate,
            String email,
            String address,
            String phoneNumber,
            String createdAt
    ) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.ssn = ssn;
        this.birthDate = birthDate;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.createdAt = createdAt;
    }

    public String getFullName() {
        if (middleName.isEmpty()) {
            return "%s %s".formatted(firstName, lastName);
        }
        return "%s %s %s".formatted(firstName, middleName, lastName);
    }

    public void update(CustomerUpdatingRequestDto requestDto) {
        this.firstName = requestDto.firstName();
        this.middleName = requestDto.middleName();
        this.lastName = requestDto.lastName();
        this.birthDate = requestDto.birthDate();
        this.email = requestDto.email();
        this.address = requestDto.address();
        this.phoneNumber = requestDto.phoneNumber();
        this.updatedAt = ZonedDateTime.now().toString();
    }

}
