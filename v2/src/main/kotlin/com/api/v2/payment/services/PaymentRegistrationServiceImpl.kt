package com.api.v2.payment.services

import com.api.v2.car.utils.CarFinderUtil
import com.api.v2.creditcard.utils.CreditCardFinderUtil
import com.api.v2.customer.utils.CustomerFinderUtil
import com.api.v2.payment.domain.Payment
import com.api.v2.payment.domain.PaymentRepository
import com.api.v2.payment.dtos.PaymentResponseDto
import com.api.v2.payment.mappers.PaymentResponseMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
private class PaymentRegistrationServiceImpl: PaymentRegistrationService {

    @Autowired
    lateinit var customerFinderUtil: CustomerFinderUtil

    @Autowired
    lateinit var carFinderUtil: CarFinderUtil

    @Autowired
    lateinit var creditCardFinderUtil: CreditCardFinderUtil

    @Autowired
    lateinit var paymentRepository: PaymentRepository

    override suspend fun register(ssn: String, vin: String, cardNumber: String): PaymentResponseDto {
        return withContext(Dispatchers.IO) {
            val customer = customerFinderUtil.find("123456789")
            val car = carFinderUtil.find("1234567890123456")
            val creditCard = creditCardFinderUtil.find("1234567890123456")
            val payment = Payment(customer, car, creditCard)
            val savedPayment =paymentRepository.save(payment)
            PaymentResponseMapper.map(savedPayment, customer, car, creditCard)
        }
    }

}