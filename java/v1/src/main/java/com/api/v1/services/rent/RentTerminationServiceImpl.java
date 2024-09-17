package com.api.v1.services.rent;

import com.api.v1.domain.rent.RentRepository;
import com.api.v1.exceptions.rent.TerminatedRentException;
import com.api.v1.utils.rent.RentFinderUtil;
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
                    if (rent.getReturnedAt() != null) {
                        return Mono.error(new TerminatedRentException(orderNumber));
                    }
                    rent.terminate();
                    return repository.save(rent);
                })
                .then();
    }

}
