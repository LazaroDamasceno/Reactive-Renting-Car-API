package com.api.v1.utils;

import com.api.v1.domain.Rent;
import com.api.v1.domain.RentRepository;
import com.api.v1.exceptions.RentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class RentFinderUtil {

    @Autowired
    private RentRepository repository;

    public Mono<Rent> find(String orderNumber) {
        return repository.
                findAll()
                .filter(e -> e.getOrderNumber().equals(orderNumber))
                .singleOrEmpty()
                .switchIfEmpty(Mono.error(new RentNotFoundException(orderNumber)));
    }

}
