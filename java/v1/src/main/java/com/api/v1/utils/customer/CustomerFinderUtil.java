package com.api.v1.utils.customer;

import com.api.v1.annotations.customer.SSN;
import com.api.v1.domain.customer.Customer;
import com.api.v1.domain.customer.CustomerRepository;
import com.api.v1.exceptions.customer.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class CustomerFinderUtil {

    @Autowired
    private CustomerRepository repository;

    public Mono<Customer> find(@SSN String ssn) {
        return repository
                .findAll()
                .filter(e -> e.getSsn().equals(ssn))
                .singleOrEmpty()
                .switchIfEmpty(Mono.error(new CustomerNotFoundException(ssn)));
    }

}
