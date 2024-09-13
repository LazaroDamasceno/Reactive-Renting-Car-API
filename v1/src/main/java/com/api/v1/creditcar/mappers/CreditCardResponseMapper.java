package com.api.v1.creditcar.mappers;

import com.api.v1.creditcar.domain.CreditCard;
import com.api.v1.creditcar.dtos.CreditCardResponseDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class CreditCardResponseMapper {

    public static Mono<CreditCardResponseDto> mapToMono(CreditCard creditCard) {
        return Mono.just(mapToDto(creditCard));
    }

    public static Flux<CreditCardResponseDto> mapToFlux(Flux<CreditCard> flux) {
        return flux.flatMap(cc -> Flux.just(mapToDto(cc)));
    }

    private static CreditCardResponseDto mapToDto(CreditCard creditCard) {
        return new CreditCardResponseDto(
                creditCard.getOwnerName(),
                creditCard.getCardNumber(),
                creditCard.getFlag(),
                creditCard.getCvc(),
                creditCard.getDueDate(),
                creditCard.getAddedAt()
        );
    }

}
