package com.api.v1.services;

import com.api.v1.domain.CreditCardRepository;
import com.api.v1.dtos.CreditCardResponseDto;
import com.api.v1.exceptions.EmptyCreditCardEntityException;
import com.api.v1.mappers.CreditCardResponseMapper;
import com.api.v1.utils.CreditCardFinderUtil;
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
                    return CreditCardResponseMapper.mapToFlux(repository.findAll());
                });
    }

    @Override
    public Mono<CreditCardResponseDto> findByCardNumber(String cardNumber) {
        return creditCardFinderUtil
                .find(cardNumber)
                .flatMap(CreditCardResponseMapper::mapToMono);
    }

}
