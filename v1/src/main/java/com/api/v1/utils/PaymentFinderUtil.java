package com.api.v1.utils;

import com.api.v1.domain.Payment;
import com.api.v1.domain.PaymentRepository;
import com.api.v1.exceptions.PaymentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.math.BigInteger;

@Component
public class PaymentFinderUtil {

    @Autowired
    private PaymentRepository repository;

    public Mono<Payment> find(String orderNumber) {
        return repository
                .findAll()
                .filter(e -> e.getOrderNumber().equals(new BigInteger(orderNumber)))
                .singleOrEmpty()
                .switchIfEmpty(Mono.error(new PaymentNotFoundException(orderNumber)));
    }

}
