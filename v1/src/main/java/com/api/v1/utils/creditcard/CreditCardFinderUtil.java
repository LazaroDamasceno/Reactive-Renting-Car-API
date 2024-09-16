package com.api.v1.utils.creditcard;

import com.api.v1.annotations.creditcard.CardNumber;
import com.api.v1.domain.creditcard.CreditCard;
import com.api.v1.domain.creditcard.CreditCardRepository;
import com.api.v1.exceptions.creditcard.CreditCardNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class CreditCardFinderUtil {

    @Autowired
    private CreditCardRepository repository;

    public Mono<CreditCard> find(@CardNumber String cardNumber) {
        return repository
                .findAll()
                .filter(e -> e.getCardNumber().equals(cardNumber))
                .singleOrEmpty()
                .switchIfEmpty(Mono.error(new CreditCardNotFoundException(cardNumber)));
    }

}
