package com.api.v1.services;

import com.api.v1.domain.PaymentRepository;
import com.api.v1.exceptions.EmptyPaymentEntityException;
import com.api.v1.utils.PaymentFinderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
class AllPaymentsDeletionServiceImpl implements AllPaymentsDeletionService {

    @Autowired
    private PaymentFinderUtil paymentFinderUtil;

    @Autowired
    private PaymentRepository repository;

    @Override
    public Mono<Void> deleteAll() {
        return repository
                .findAll()
                .hasElements()
                .flatMap(hasElements -> {
                    if (!hasElements) return Mono.error(EmptyPaymentEntityException::new);
                    return repository.deleteAll();
                });
    }

    @Override
    public Mono<Void> deleteByOrderNumber(String orderNumber) {
        return paymentFinderUtil
                .find(orderNumber)
                .flatMap(payment -> repository.delete(payment));
    }

}
