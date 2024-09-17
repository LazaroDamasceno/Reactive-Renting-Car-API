package com.api.v1.services.payment;

import com.api.v1.domain.payment.PaymentRepository;
import com.api.v1.dtos.payment.PaymentResponseDto;
import com.api.v1.exceptions.payment.EmptyPaymentEntityException;
import com.api.v1.mappers.payment.PaymentResponseMapper;
import com.api.v1.utils.payment.PaymentFinderUtil;
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
                                payment.getCreditCard())
                                .map()
                ));
    }
}
