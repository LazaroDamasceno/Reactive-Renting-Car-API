package com.api.v1.creditcar.services;

import com.api.v1.creditcar.domain.CreditCardRepository;
import com.api.v1.creditcar.exceptions.EmptyCreditCardEntityException;
import com.api.v1.creditcar.utils.CreditCardFinderUtil;
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
    public Mono<Void> deleteByCardNumber(String cardNumber) {
        return creditCardFinderUtil
                .find(cardNumber)
                .flatMap(cc -> repository.delete(cc));
    }

}
