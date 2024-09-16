package com.api.v1.services.customer;

import com.api.v1.exceptions.creditcard.EmptyCreditCardEntityException;
import com.api.v1.annotations.customer.SSN;
import com.api.v1.domain.customer.CustomerRepository;
import com.api.v1.dtos.customer.CustomerResponseDto;
import com.api.v1.mappers.customer.CustomerResponseMapper;
import com.api.v1.utils.customer.CustomerFinderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
class AllCustomersRetrievingServiceImpl implements AllCustomersRetrievingService {

    @Autowired
    private CustomerFinderUtil customerFinderUtil;

    @Autowired
    private CustomerRepository repository;

    @Override
    public Mono<CustomerResponseDto> findBySsn(@SSN String ssn) {
        return customerFinderUtil
                .find(ssn)
                .flatMap(e -> Mono.just(new CustomerResponseMapper(e).mapToDto()));
    }

    @Override
    public Flux<CustomerResponseDto> findAll() {
        return repository
                .findAll()
                .hasElements()
                .flatMapMany(hasElements -> {
                    if (!hasElements) return Mono.error(new EmptyCreditCardEntityException());
                    return repository.findAll().flatMap(e -> Flux.just(new CustomerResponseMapper(e).mapToDto()));
                });
    }

}
