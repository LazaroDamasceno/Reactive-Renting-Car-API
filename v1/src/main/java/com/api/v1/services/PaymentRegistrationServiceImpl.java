package com.api.v1.services;

import com.api.v1.annotations.*;
import com.api.v1.builders.PaymentBuilder;
import com.api.v1.domain.*;
import com.api.v1.dtos.PaymentResponseDto;
import com.api.v1.mappers.PaymentResponseMapper;
import com.api.v1.utils.CarFinderUtil;
import com.api.v1.utils.CreditCardFinderUtil;
import com.api.v1.utils.CustomerFinderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
class PaymentRegistrationServiceImpl implements PaymentRegistrationService {

    @Autowired
    private PaymentRepository repository;

    @Autowired
    private CustomerFinderUtil customerFinderUtil;

    @Autowired
    private CarFinderUtil carFinderUtil;

    @Autowired
    private CreditCardFinderUtil creditCardFinderUtil;

    @Override
    public Mono<PaymentResponseDto> register(@SSN String ssn, @VIN String vin, @CardNumber String cardNumber) {
        Mono<Customer> customerMono = customerFinderUtil.find(ssn);
        Mono<Car> carMono = carFinderUtil.find(vin);
        Mono<CreditCard> creditCardMono = creditCardFinderUtil.find(cardNumber);
        return Mono.zip(customerMono, carMono, creditCardMono)
                .flatMap(tuple -> {
                    Customer customer = tuple.getT1();
                    Car car = tuple.getT2();
                    CreditCard creditCard = tuple.getT3();
                    Payment payment = PaymentBuilder
                            .create()
                            .withCustomer(customer)
                            .withCar(car)
                            .withCreditCard(creditCard)
                            .build();
                    return repository.save(payment)
                            .flatMap(savedPayment -> Mono.just(
                                    new PaymentResponseMapper(savedPayment, creditCard).map()));
                });
    }

}
