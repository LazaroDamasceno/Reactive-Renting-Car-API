package com.api.v1.utils.rent;

import com.api.v1.domain.rent.Rent;
import com.api.v1.domain.rent.RentRepository;
import com.api.v1.exceptions.rent.RentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.math.BigInteger;

@Component
public class RentFinderUtil {

    @Autowired
    private RentRepository repository;

    public Mono<Rent> find(String orderNumber) {
        return repository.
                findAll()
                .filter(e -> e.getOrderNumber().equals(new BigInteger(orderNumber)))
                .singleOrEmpty()
                .switchIfEmpty(Mono.error(new RentNotFoundException(orderNumber)));
    }

}
