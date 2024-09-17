package com.api.v1.domain.car;

import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.api.v1.dtos.car.CarUpdatingRequestDto;

import lombok.Getter;

@Getter
@Document(collection = "v1_cars")
public class Car {

    @Id
    private UUID id;

    @Field
    private String make;

    @Field
    private String model;

    @Field
    private int productionYear;

    @Field
    private String vin;

    @Field
    private String plateNumber;

    @Field
    private String addedAt;

    @Field
    private String updatedAt;

    @Field
    private Set<String> plateNumbers = new HashSet<>();

    public Car(
            UUID id,
            String make,
            String model,
            int productionYear,
            String vin,
            String plateNumber,
            String addedAt
    ) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.productionYear = productionYear;
        this.vin = vin;
        this.plateNumber = plateNumber;
        this.addedAt = addedAt;
    }

    public void update(CarUpdatingRequestDto requestDto) {
        this.make = requestDto.make();
        this.model = requestDto.model();
        this.productionYear = requestDto.productionYear();
        this.plateNumber = requestDto.plateNumber();
        this.updatedAt = ZonedDateTime.now().toString();
    }

}
