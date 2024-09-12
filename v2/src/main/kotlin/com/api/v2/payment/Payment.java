package com.api.v2.payment;

import com.api.v2.creditcard.CreditCard;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "v1_payments")
public record Payment(
        CreditCard creditCard,
        String paidAt,
        Rent rent
) {
}
