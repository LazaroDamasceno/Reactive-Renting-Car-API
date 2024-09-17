package com.api.v1.services.customer;

import com.api.v1.mappers.customer.CustomerResponseMapper;
import com.api.v1.builders.customer.CustomerBuilder;
import com.api.v1.domain.customer.Customer;
import com.api.v1.domain.customer.CustomerRepository;
import com.api.v1.dtos.customer.CustomerRegistrationRequestDto;
import com.api.v1.dtos.customer.CustomerResponseDto;
import com.api.v1.exceptions.customer.DuplicatedSsnException;
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
                    })
                    .flatMap(e -> Mono.just(new CustomerResponseMapper(e).mapToDto()));
                });
    }

}
