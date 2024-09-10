package com.api.v1.customer.services;

import com.api.v1.EmptyFluxException;
import com.api.v1.customer.annotations.SSN;
import com.api.v1.customer.domain.Customer;
import com.api.v1.customer.domain.CustomerRepository;
import com.api.v1.customer.dtos.CustomerResponseDto;
import com.api.v1.customer.mappers.CustomerResponseMapper;
import com.api.v1.customer.utils.CustomerFinderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
class AllCustomerRetrievingServiceImpl implements AllCustomerRetrievingService {

    @Autowired
    private CustomerFinderUtil customerFinderUtil;

    @Autowired
    private CustomerRepository repository;

    @Override
    public Mono<CustomerResponseDto> findBySsn(@SSN String ssn) {
        return customerFinderUtil
                .find(ssn)
                .flatMap(CustomerResponseMapper::mapToMono);
    }

    @Override
    public Flux<CustomerResponseDto> findAll() {
        return repository
                .findAll()
                .hasElements()
                .flatMapMany(hasElements -> {
                    if (!hasElements) return Mono.error(new EmptyFluxException());
                    return CustomerResponseMapper.mapToFlux(repository.findAll());
                });
    }

}
