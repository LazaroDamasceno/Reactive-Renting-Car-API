package com.api.v1.creditcar.services;

import com.api.v1.creditcar.domain.CreditCard;
import com.api.v1.creditcar.domain.CreditCardRepository;
import com.api.v1.creditcar.dtos.CreditCardResponseDto;
import com.api.v1.creditcar.exceptions.DuplicatedCardNumberException;
import com.api.v1.creditcar.mappers.CreditCardResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
class CreditCardRegistrationServiceImpl implements CreditCardRegistrationService {

    @Autowired
    private CreditCardRepository repository;

    @Override
    public Mono<CreditCardResponseDto> register(CreditCard creditCard) {
        return repository
                .findAll()
                .filter(e -> e.cardNumber().equals(creditCard.cardNumber()))
                .hasElements()
                .flatMap(exists -> {
                    if (exists) return Mono.error(new DuplicatedCardNumberException(creditCard.cardNumber()));
                    return Mono.defer(() -> {
                        var savedCreditCard = repository.save(creditCard);
                       return savedCreditCard.flatMap(CreditCardResponseMapper::map);
                    });
                });
    }

}
