package com.api.v1.services.rent;

import com.api.v1.annotations.customer.SSN;
import com.api.v1.annotations.car.VIN;
import com.api.v1.builders.rent.RentBuilder;
import com.api.v1.domain.car.Car;
import com.api.v1.domain.customer.Customer;
import com.api.v1.domain.payment.Payment;
import com.api.v1.domain.rent.Rent;
import com.api.v1.domain.rent.RentRepository;
import com.api.v1.dtos.rent.RentResponseDto;
import com.api.v1.mappers.rent.RentResponseMapper;
import com.api.v1.utils.car.CarFinderUtil;
import com.api.v1.utils.customer.CustomerFinderUtil;
import com.api.v1.utils.payment.PaymentFinderUtil;
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
