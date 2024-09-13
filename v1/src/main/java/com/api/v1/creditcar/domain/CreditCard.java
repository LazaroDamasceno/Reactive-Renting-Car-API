package com.api.v1.creditcar.domain;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Document(collection = "v1_credit_cards")
public class CreditCard {

    @Id
    private UUID id;

    @Field
    private String ownerName;

    @Field
    private String cardNumber;

    @Field
    private String flag;

    @Field
    private String cvc;

    @Field
    private LocalDate dueDate;

    @Field
    private String addedAt;

    public CreditCard(
            String ownerName,
            String cardNumber,
            String flag,
            String cvc,
            LocalDate dueDate
    ) {
        this.id = UUID.randomUUID();
        this.ownerName = ownerName;
        this.cardNumber = cardNumber;
        this.flag = flag;
        this.cvc = cvc;
        this.dueDate = dueDate;
        this.addedAt = ZonedDateTime.now().toString();
    }

}
