package com.api.v1.services.customer;

import com.api.v1.builders.creditcard.CreditCardBuilder;
import com.api.v1.domain.creditcard.CreditCard;
import com.api.v1.domain.creditcard.CreditCardRepository;
import com.api.v1.dtos.creditcard.CreditCardRegistrationRequestDto;
import com.api.v1.dtos.creditcard.CreditCardResponseDto;
import com.api.v1.exceptions.creditcard.DuplicatedCardNumberException;
import com.api.v1.mappers.creditcard.CreditCardResponseMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
class CreditCardRegistrationServiceImpl implements CreditCardRegistrationService {

    @Autowired
    private CreditCardRepository repository;

    @Override
    public Mono<CreditCardResponseDto> register(@Valid CreditCardRegistrationRequestDto requestDto) {
        return repository
                .findAll()
                .filter(e -> e.getCardNumber().equals(requestDto.cardNumber()))
                .hasElements()
                .flatMap(exists -> {
                    if (exists) return Mono.error(new DuplicatedCardNumberException(requestDto.cardNumber()));
                    return Mono.defer(() -> {
                        CreditCard creditCard = CreditCardBuilder.create().fromDto(requestDto).build();
                        Mono<CreditCard> savedCreditCard = repository.save(creditCard);
                       return savedCreditCard.flatMap(e -> Mono.just(new CreditCardResponseMapper(e).mapToDto()));
                    });
                });
    }

}
