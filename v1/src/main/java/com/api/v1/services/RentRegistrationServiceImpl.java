package com.api.v1.services;

import com.api.v1.annotations.SSN;
import com.api.v1.annotations.VIN;
import com.api.v1.builders.RentBuilder;
import com.api.v1.domain.*;
import com.api.v1.dtos.RentResponseDto;
import com.api.v1.mappers.RentResponseMapper;
import com.api.v1.utils.CarFinderUtil;
import com.api.v1.utils.CustomerFinderUtil;
import com.api.v1.utils.PaymentFinderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
class RentRegistrationServiceImpl implements RentRegistrationService {

    @Autowired
    private RentRepository repository;

    @Autowired
    private CustomerFinderUtil customerFinderUtil;

    @Autowired
    private CarFinderUtil carFinderUtil;

    @Autowired
    private PaymentFinderUtil paymentFinderUtil;

    @Override
    public Mono<RentResponseDto> register(
            @SSN String ssn,
            @VIN String vin,
            String paymentOrderNumber,
            int days
    ) {
        Mono<Customer> customerMono = customerFinderUtil.find(ssn);
        Mono<Car> carMono = carFinderUtil.find(vin);
        Mono<Payment> paymentMono = paymentFinderUtil.find(paymentOrderNumber);
        return Mono.zip(customerMono, carMono, paymentMono)
                .flatMap(tuple -> {
                    Customer customer = tuple.getT1();
                    Car car = tuple.getT2();
                    Payment payment = tuple.getT3();
                    Rent rent = RentBuilder
                            .create()
                            .withCar(car)
                            .withCustomer(customer)
                            .withPayment(payment)
                            .withDays(days)
                            .build();
                    return repository
                            .save(rent)
                            .flatMap(e -> Mono.just(new RentResponseMapper(rent, customer, car, payment).map()));
                });
    }

}
