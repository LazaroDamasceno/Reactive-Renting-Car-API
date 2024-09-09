package com.api.v1.customer.mappers;

import com.api.v1.customer.domain.Customer;
import com.api.v1.customer.dtos.CustomerResponseDto;
import reactor.core.publisher.Mono;

public class CustomerResponseMapper {

    public static Mono<CustomerResponseDto> map(Customer customer) {
        return Mono.just(new CustomerResponseDto(
                customer.getFullName(),
                customer.getSsn(),
                customer.getBirthDate(),
                customer.getEmail(),
                customer.getAddress(),
                customer.getPhoneNumber(),
                customer.getCreatedAt(),
                customer.getUpdatedAt()
        ));
    }

}
