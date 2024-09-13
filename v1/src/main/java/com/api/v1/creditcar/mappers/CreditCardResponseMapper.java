package com.api.v1.creditcar.mappers;

import com.api.v1.creditcar.domain.CreditCard;
import com.api.v1.creditcar.dtos.CreditCardResponseDto;

public record CreditCardResponseMapper(CreditCard creditCard) {

    public CreditCardResponseDto mapToDto() {
        return new CreditCardResponseDto(
                creditCard.getOwnerName(),
                creditCard.getCardNumber(),
                creditCard.getDueDate()
        );
    }

}
