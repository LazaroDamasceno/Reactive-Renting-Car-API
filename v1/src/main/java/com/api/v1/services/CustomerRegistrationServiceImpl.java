package com.api.v1.services;

import com.api.v1.mappers.CreditCardResponseMapper;
import com.api.v1.mappers.CustomerResponseMapper;
import com.api.v1.builders.CustomerBuilder;
import com.api.v1.domain.Customer;
import com.api.v1.domain.CustomerRepository;
import com.api.v1.dtos.CustomerRegistrationRequestDto;
import com.api.v1.dtos.CustomerResponseDto;
import com.api.v1.exceptions.DuplicatedSsnException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
class CustomerRegistrationServiceImpl implements CustomerRegistrationService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Mono<CustomerResponseDto> register(@Valid CustomerRegistrationRequestDto request) {
        return customerRepository
                .findAll()
                .filter(e -> e.getSsn().equals(request.ssn()))
                .hasElements()
                .flatMap(exists -> {
                    if (exists) return Mono.error(new DuplicatedSsnException(request.ssn()));
                    return Mono.defer(() -> {
                        Customer customer = CustomerBuilder.create().fromDto(request).build();
                        return customerRepository.save(customer);
                    }).flatMap(e -> Mono.just(new CustomerResponseMapper(e).mapToDto()));
                });
    }

}
