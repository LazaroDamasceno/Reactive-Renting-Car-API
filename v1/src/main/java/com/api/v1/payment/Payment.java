package com.api.v1.payment;

import com.api.v1.rent.Rent;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.UUID;

@Getter
@Document(collection = "v1_rents")
public class Payment {

    @Id
    private final UUID id;

    @Field
    private final String paidAAt;

    @Field
    private final Rent rent;

    public Payment(UUID id, String paidAAt, Rent rent) {
        this.id = id;
        this.paidAAt = paidAAt;
        this.rent = rent;
    }

}
