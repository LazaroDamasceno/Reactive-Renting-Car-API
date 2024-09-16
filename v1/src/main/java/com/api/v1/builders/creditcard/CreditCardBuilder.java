package com.api.v1.builders.creditcard;

import com.api.v1.domain.creditcard.CreditCard;
import com.api.v1.dtos.creditcard.CreditCardRegistrationRequestDto;

import java.time.LocalDate;

public class CreditCardBuilder {

    String ownerName;
    String cardNumber;
    String flag;
    String cvc;
    LocalDate dueDate;

    private CreditCardBuilder() {}

    public static CreditCardBuilder create() {
        return new CreditCardBuilder();
    }

    public CreditCardBuilder fromDto(CreditCardRegistrationRequestDto requestDto) {
        ownerName = requestDto.ownerName();
        cardNumber = requestDto.cardNumber();
        flag = requestDto.flag();
        cvc = requestDto.cvc();
        dueDate = requestDto.dueDate();
        return this;
    }

    public CreditCard build() {
        return new CreditCard(
                ownerName,
                cardNumber,
                flag,
                cvc,
                dueDate
        );
    }

}
