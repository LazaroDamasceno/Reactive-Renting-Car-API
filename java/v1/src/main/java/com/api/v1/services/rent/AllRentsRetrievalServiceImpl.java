package com.api.v1.services.rent;

import com.api.v1.domain.rent.RentRepository;
import com.api.v1.dtos.rent.RentResponseDto;
import com.api.v1.mappers.rent.RentResponseMapper;
import com.api.v1.utils.rent.RentFinderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
class AllRentsRetrievalServiceImpl implements AllRentsRetrievalService {

    @Autowired
    private RentRepository repository;

    @Autowired
    private RentFinderUtil rentFinderUtil;

    @Override
    public Mono<RentResponseDto> findByOrderNumber(String orderNumber) {
        return rentFinderUtil
                .find(orderNumber)
                .flatMap(rent -> Mono.just(new RentResponseMapper(
                        rent,
                        rent.getCustomer(),
                        rent.getCar(),
                        rent.getPayment()
                ).map()));
    }

    @Override
    public Flux<RentResponseDto> findAll() {
        return repository
                .findAll()
                .flatMap(rent -> Mono.just(new RentResponseMapper(
                        rent,
                        rent.getCustomer(),
                        rent.getCar(),
                        rent.getPayment()
                ).map()));
    }

}
