package com.api.v1.customer;

import com.api.v1.customer.domain.Customer;
import com.api.v1.customer.dtos.CustomerResponseDto;

public class CustomerResponseMapper {

    public static CustomerResponseDto map(Customer customer) {
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
