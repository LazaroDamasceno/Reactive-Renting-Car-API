package com.api.v1.customer.services;

import com.api.v1.customer.annotations.SSN;
import com.api.v1.customer.domain.CustomerRepository;
import com.api.v1.customer.exceptions.CustomerEntityNotExistsException;
import com.api.v1.customer.utils.CustomerFinderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
class CustomerDeletionServiceImpl implements CustomerDeletionService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerFinderUtil customerFinderUtil;

    @Override
    public Mono<Void> deleteAll() {
        return customerRepository
                .findAll()
                .hasElements()
                .flatMap(hasElements -> {
                    if (!hasElements) return Mono.error(CustomerEntityNotExistsException::new);
                    return customerRepository.deleteAll();
                });
    }

    @Override
    public Mono<Void> deleteBySsn(@SSN String ssn) {
        return customerFinderUtil
                .find(ssn)
                .flatMap(customer -> customerRepository.delete(customer))
                .then();
    }

}
