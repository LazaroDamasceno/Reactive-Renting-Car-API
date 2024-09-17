package com.api.v1.mappers.creditcard;

import com.api.v1.domain.creditcard.CreditCard;
import com.api.v1.dtos.creditcard.CreditCardResponseDto;

public record CreditCardResponseMapper(CreditCard creditCard) {

    public CreditCardResponseDto mapToDto() {
        return new CreditCardResponseDto(
                creditCard.getOwnerName(),
                creditCard.getCardNumber(),
                creditCard.getDueDate()
        );
    }

}
