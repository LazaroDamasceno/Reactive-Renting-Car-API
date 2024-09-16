package com.api.v1.services.payment;

import com.api.v1.annotations.car.VIN;
import com.api.v1.annotations.creditcard.CardNumber;
import com.api.v1.annotations.customer.SSN;
import com.api.v1.builders.payment.PaymentBuilder;
import com.api.v1.domain.car.Car;
import com.api.v1.domain.creditcard.CreditCard;
import com.api.v1.domain.customer.Customer;
import com.api.v1.domain.payment.Payment;
import com.api.v1.domain.payment.PaymentRepository;
import com.api.v1.dtos.payment.PaymentResponseDto;
import com.api.v1.mappers.payment.PaymentResponseMapper;
import com.api.v1.utils.car.CarFinderUtil;
import com.api.v1.utils.creditcard.CreditCardFinderUtil;
import com.api.v1.utils.customer.CustomerFinderUtil;
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
