package com.api.v1.customer.mappers;

import com.api.v1.customer.domain.Customer;
import com.api.v1.customer.dtos.CustomerResponseDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class CustomerResponseMapper {

    public static Mono<CustomerResponseDto> mapToMono(Customer customer) {
        return Mono.just(mapToDto(customer));
    }

    public static Flux<CustomerResponseDto> mapToFlux(Flux<Customer> customers) {
        return customers.flatMap(customer -> Flux.just(mapToDto(customer)));
    }

    private static CustomerResponseDto mapToDto(Customer customer) {
        return new CustomerResponseDto(
                customer.getFullName(),
                customer.getSsn(),
                customer.getBirthDate(),
                customer.getEmail(),
                customer.getAddress(),
                customer.getPhoneNumber(),
                customer.getCreatedAt(),
                customer.getUpdatedAt()
        );
    }

}
