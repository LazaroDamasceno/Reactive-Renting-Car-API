package com.api.v1.creditcar.services;

import com.api.v1.creditcar.builders.CreditCardBuilder;
import com.api.v1.creditcar.domain.CreditCard;
import com.api.v1.creditcar.domain.CreditCardRepository;
import com.api.v1.creditcar.dtos.CreditCardRegistrationRequestDto;
import com.api.v1.creditcar.dtos.CreditCardResponseDto;
import com.api.v1.creditcar.exceptions.DuplicatedCardNumberException;
import com.api.v1.creditcar.mappers.CreditCardResponseMapper;
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
                       return savedCreditCard.flatMap(CreditCardResponseMapper::mapToMono);
                    });
                });
    }

}
