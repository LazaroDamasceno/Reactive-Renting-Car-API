package com.api.v1.services;

import com.api.v1.annotations.CardNumber;
import com.api.v1.domain.CreditCardRepository;
import com.api.v1.exceptions.EmptyCreditCardEntityException;
import com.api.v1.utils.CreditCardFinderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
class AllCreditCardsDeletionServiceImpl implements AllCreditCardsDeletionService {

    @Autowired
    private CreditCardRepository repository;

    @Autowired
    private CreditCardFinderUtil creditCardFinderUtil;

    @Override
    public Mono<Void> deleteAll() {
        return repository
                .findAll()
                .hasElements()
                .flatMap(hasElements -> {
                    if (!hasElements) return Mono.error(new EmptyCreditCardEntityException());
                    return repository.deleteAll();
                });
    }

    @Override
    public Mono<Void> deleteByCardNumber(@CardNumber String cardNumber) {
        return creditCardFinderUtil
                .find(cardNumber)
                .flatMap(cc -> repository.delete(cc));
    }

}
