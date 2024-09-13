package com.api.v1.services;

import com.api.v1.exceptions.EmptyCreditCardEntityException;
import com.api.v1.annotations.SSN;
import com.api.v1.domain.CustomerRepository;
import com.api.v1.dtos.CustomerResponseDto;
import com.api.v1.mappers.CustomerResponseMapper;
import com.api.v1.utils.CustomerFinderUtil;
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
