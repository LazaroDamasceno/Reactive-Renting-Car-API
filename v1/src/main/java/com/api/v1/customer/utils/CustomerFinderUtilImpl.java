package com.api.v1.customer.utils;

import com.api.v1.customer.annotations.SSN;
import com.api.v1.customer.domain.Customer;
import com.api.v1.customer.domain.CustomerRepository;
import com.api.v1.customer.exceptions.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
class CustomerFinderUtilImpl implements CustomerFinderUtil {

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
