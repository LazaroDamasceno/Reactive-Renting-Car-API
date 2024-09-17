package com.api.v1.services.customer;

import com.api.v1.annotations.customer.SSN;
import com.api.v1.domain.customer.CustomerRepository;
import com.api.v1.dtos.customer.CustomerResponseDto;
import com.api.v1.dtos.customer.CustomerUpdatingRequestDto;
import com.api.v1.mappers.customer.CustomerResponseMapper;
import com.api.v1.utils.customer.CustomerFinderUtil;
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
                .flatMap(e -> Mono.just(new CustomerResponseMapper(e).mapToDto()));
    }

}
