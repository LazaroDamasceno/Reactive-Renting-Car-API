package com.api.v1.services;

import com.api.v1.domain.RentRepository;
import com.api.v1.exceptions.EmptyRentEntityException;
import com.api.v1.mappers.RentResponseMapper;
import com.api.v1.utils.RentFinderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
class AllRentsDeletionServiceImpl implements AllRentsDeletionService {

    @Autowired
    private RentRepository repository;

    @Autowired
    private RentFinderUtil rentFinderUtil;

    @Override
    public Mono<Void> deleteAll() {
        return repository
                .findAll()
                .hasElements()
                .flatMap(hasElements -> {
                    if (!hasElements) return Mono.error(EmptyRentEntityException::new);
                    return repository.deleteAll();
                });
    }

    @Override
    public Mono<Void> deleteByOrderNumber(String orderNumber) {
        return rentFinderUtil
                .find(orderNumber)
                .flatMap(rent -> repository.delete(rent));
    }

}
