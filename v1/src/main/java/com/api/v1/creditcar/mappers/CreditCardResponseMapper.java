package com.api.v1.creditcar.mappers;

import com.api.v1.creditcar.domain.CreditCard;
import com.api.v1.creditcar.dtos.CreditCarResponseDto;
import reactor.core.publisher.Mono;

public class CreditCardResponseMapper {

    public static Mono<CreditCarResponseDto> map(CreditCard creditCard) {
        return Mono.just(new CreditCarResponseDto(
                creditCard.ownerName(),
                creditCard.cardNumber(),
                creditCard.flag(),
                creditCard.cvc(),
                creditCard.dueDate(),
                creditCard.addedAt()
        ));
    }

}
