package com.api.v1.utils;

import com.api.v1.domain.CreditCard;
import com.api.v1.domain.CreditCardRepository;
import com.api.v1.exceptions.CreditCardNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class CreditCardFinderUtil {

    @Autowired
    private CreditCardRepository repository;

    public Mono<CreditCard> find(String cardNumber) {
        return repository
                .findAll()
                .filter(e -> e.getCardNumber().equals(cardNumber))
                .singleOrEmpty()
                .switchIfEmpty(Mono.error(new CreditCardNotFoundException(cardNumber)));
    }

}
