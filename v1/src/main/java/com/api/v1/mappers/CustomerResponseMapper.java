package com.api.v1.mappers;

import com.api.v1.domain.Customer;
import com.api.v1.dtos.CustomerResponseDto;

public record CustomerResponseMapper(Customer customer) {

    public CustomerResponseDto mapToDto() {
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
