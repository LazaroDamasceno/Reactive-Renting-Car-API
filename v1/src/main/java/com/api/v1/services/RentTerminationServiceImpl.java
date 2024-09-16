package com.api.v1.services;

import com.api.v1.domain.RentRepository;
import com.api.v1.exceptions.TerminatedRentException;
import com.api.v1.utils.RentFinderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
class RentTerminationServiceImpl implements RentTerminationService {

    @Autowired
    private RentRepository repository;

    @Autowired
    private RentFinderUtil rentFinderUtil;

    @Override
    public Mono<Void> terminate(String orderNumber) {
        return rentFinderUtil
                .find(orderNumber)
                .flatMap(rent -> {
                    if (rent.getRentedAt() == null) {
                        return Mono.error(new TerminatedRentException(orderNumber));
                    }
                    return repository.delete(rent);
                })
                .then();
    }

}
