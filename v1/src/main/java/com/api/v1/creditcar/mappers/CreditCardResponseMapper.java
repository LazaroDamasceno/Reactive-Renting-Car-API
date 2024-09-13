package com.api.v1.creditcar.mappers;

import com.api.v1.creditcar.domain.CreditCard;
import com.api.v1.creditcar.dtos.CreditCarResponseDto;

public class CreditCardResponseMapper {

    public static CreditCarResponseDto map(CreditCard creditCard) {
        return new CreditCarResponseDto(
                creditCard.ownerName(),
                creditCard.cardNumber(),
                creditCard.flag(),
                creditCard.cvc(),
                creditCard.dueDate(),
                creditCard.addedAt()
        );
    }

}
