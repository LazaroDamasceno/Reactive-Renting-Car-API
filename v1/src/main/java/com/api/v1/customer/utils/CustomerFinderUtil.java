package com.api.v1.customer.utils;

import com.api.v1.customer.annotations.SSN;
import com.api.v1.customer.domain.Customer;
import reactor.core.publisher.Mono;

public interface CustomerFinderUtil {

    Mono<Customer> find(@SSN String ssn);

}
