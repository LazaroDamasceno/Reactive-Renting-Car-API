package com.api.v1.creditcar.mappers;

import com.api.v1.creditcar.domain.CreditCard;
import com.api.v1.creditcar.dtos.CreditCardResponseDto;
import reactor.core.publisher.Mono;

public class CreditCardResponseMapper {

    public static Mono<CreditCardResponseDto> map(CreditCard creditCard) {
        return Mono.just(new CreditCardResponseDto(
                creditCard.getOwnerName(),
                creditCard.getCardNumber(),
                creditCard.getFlag(),
                creditCard.getCvc(),
                creditCard.getDueDate(),
                creditCard.getAddedAt()
        ));
    }

}
