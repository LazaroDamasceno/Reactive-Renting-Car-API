package com.api.v1.customer.services;

import com.api.v1.customer.annotations.SSN;
import com.api.v1.customer.domain.CustomerRepository;
import com.api.v1.customer.dtos.CustomerResponseDto;
import com.api.v1.customer.dtos.CustomerUpdatingRequestDto;
import com.api.v1.customer.mappers.CustomerResponseMapper;
import com.api.v1.customer.utils.CustomerFinderUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
class CustomerUpdatingServiceImpl implements CustomerUpdatingService {

    @Autowired
    private CustomerFinderUtil customerFinderUtil;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Mono<CustomerResponseDto> update(@SSN String ssn, @Valid CustomerUpdatingRequestDto requestDto) {
        return customerFinderUtil
                .find(ssn)
                .flatMap(customer -> {
                    customer.update(requestDto);
                    return customerRepository.save(customer);
                })
                .flatMap(CustomerResponseMapper::mapToMono);
    }

}
