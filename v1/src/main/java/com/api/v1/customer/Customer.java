package com.api.v1.customer;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.util.UUID;

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

}
