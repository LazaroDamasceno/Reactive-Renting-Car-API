package com.api.v1.services.creditcard;

import com.api.v1.annotations.creditcard.CardNumber;
import com.api.v1.domain.creditcard.CreditCardRepository;
import com.api.v1.dtos.creditcard.CreditCardResponseDto;
import com.api.v1.exceptions.creditcard.EmptyCreditCardEntityException;
import com.api.v1.mappers.creditcard.CreditCardResponseMapper;
import com.api.v1.utils.creditcard.CreditCardFinderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
class AllCreditCardsRetrievalServiceImpl implements AllCreditCardsRetrievalService {

    @Autowired
    private CreditCardRepository repository;

    @Autowired
    private CreditCardFinderUtil creditCardFinderUtil;

    @Override
    public Flux<CreditCardResponseDto> findAll() {
        return repository
                .findAll()
                .hasElements()
                .flatMapMany(hasElements -> {
                    if (!hasElements) return Mono.error(new EmptyCreditCardEntityException());
                    return repository
                            .findAll()
                            .flatMap(e -> Flux.just(new CreditCardResponseMapper(e).mapToDto()));
                });
    }

    @Override
    public Mono<CreditCardResponseDto> findByCardNumber(@CardNumber String cardNumber) {
        return creditCardFinderUtil
                .find(cardNumber)
                .flatMap(e -> Mono.just(new CreditCardResponseMapper(e).mapToDto()));
    }

}
