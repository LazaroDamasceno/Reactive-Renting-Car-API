package com.api.v1.services;

import com.api.v1.domain.PaymentRepository;
import com.api.v1.dtos.PaymentResponseDto;
import com.api.v1.exceptions.EmptyPaymentEntityException;
import com.api.v1.mappers.PaymentResponseMapper;
import com.api.v1.utils.PaymentFinderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
class AllPaymentsRetrievalServiceImpl implements AllPaymentsRetrievalService {

    @Autowired
    private PaymentFinderUtil paymentFinderUtil;

    @Autowired
    private PaymentRepository repository;

    @Override
    public Flux<PaymentResponseDto> findAll() {
        return repository
                .findAll()
                .hasElements()
                .flatMapMany(hasElements -> {
                    if (!hasElements) return Mono.error(EmptyPaymentEntityException::new);
                    return repository
                            .findAll()
                            .flatMap(payment -> Mono.just(
                                    new PaymentResponseMapper(
                                            payment,
                                            payment.getCustomer(),
                                            payment.getCar(),
                                            payment.getCreditCard())
                                            .map()
                            ));
                });
    }

    @Override
    public Mono<PaymentResponseDto> findByOrderNumber(String orderNumber) {
        return paymentFinderUtil
                .find(orderNumber)
                .flatMap(payment -> Mono.just(
                        new PaymentResponseMapper(
                                payment,
                                payment.getCustomer(),
                                payment.getCar(),
                                payment.getCreditCard())
                                .map()
                ));
    }
}
