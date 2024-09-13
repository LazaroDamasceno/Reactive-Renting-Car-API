package com.api.v1.utils;

import com.api.v1.annotations.SSN;
import com.api.v1.domain.Customer;
import com.api.v1.domain.CustomerRepository;
import com.api.v1.exceptions.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
class CustomerFinderUtil implements CustomerFinderUtil {

    @Autowired
    private CustomerRepository repository;

    @Override
    public Mono<Customer> find(@SSN String ssn) {
        return repository
                .findAll()
                .filter(e -> e.getSsn().equals(ssn))
                .singleOrEmpty()
                .switchIfEmpty(Mono.error(new CustomerNotFoundException(ssn)));
    }

}
