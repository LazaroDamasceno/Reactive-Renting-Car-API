package com.api.v1.mappers;

import com.api.v1.domain.CreditCard;
import com.api.v1.dtos.CreditCardResponseDto;

public record CreditCardResponseMapper(CreditCard creditCard) {

    public CreditCardResponseDto mapToDto() {
        return new CreditCardResponseDto(
                creditCard.getOwnerName(),
                creditCard.getCardNumber(),
                creditCard.getDueDate()
        );
    }

}
