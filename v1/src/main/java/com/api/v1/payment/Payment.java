package com.api.v1.payment;

import com.api.v1.creditcar.domain.CreditCard;
import com.api.v1.rent.Rent;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "v1_payments")
public record Payment(
        CreditCard creditCard,
        String paidAAt,
        Rent rent
) {}
