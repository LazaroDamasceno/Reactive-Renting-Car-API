package com.api.v2.payment

import com.api.v2.car.utils.CarFinderUtil
import com.api.v2.creditcard.utils.CreditCardFinderUtil
import com.api.v2.customer.utils.CustomerFinderUtil
import com.api.v2.payment.domain.Payment
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.TestMethodOrder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.reactive.server.WebTestClient

@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
private class PaymentRegistrationTest {

    @Autowired
    lateinit var webTestClient: WebTestClient

    @Autowired
    lateinit var customerFinderUtil: CustomerFinderUtil

    @Autowired
    lateinit var carFinderUtil: CarFinderUtil

    @Autowired
    lateinit var creditCardFinderUtil: CreditCardFinderUtil

    suspend fun testSuccessfulPaymentRegistration() {
        val customer = customerFinderUtil.find("123456789")
        val car = carFinderUtil.find("1234567890123456")
        val creditCard = creditCardFinderUtil.find("1234567890123456")
        val payment = Payment(customer, car, creditCard)
        webTestClient
            .post()
            .uri("api/v2/payments")
            .bodyValue(payment)
            .exchange()
            .expectStatus()
            .is2xxSuccessful()
    }

    suspend fun testUnsuccessfulPaymentRegistration1() {
        val customer = customerFinderUtil.find("123456788")
        val car = carFinderUtil.find("1234567890123456")
        val creditCard = creditCardFinderUtil.find("1234567890123456")
        val payment = Payment(customer, car, creditCard)
        webTestClient
            .post()
            .uri("api/v2/payments")
            .bodyValue(payment)
            .exchange()
            .expectStatus()
            .is5xxServerError()
    }

    suspend fun testUnsuccessfulPaymentRegistration2() {
        val customer = customerFinderUtil.find("123456789")
        val car = carFinderUtil.find("1234567890123455")
        val creditCard = creditCardFinderUtil.find("1234567890123456")
        val payment = Payment(customer, car, creditCard)
        webTestClient
            .post()
            .uri("api/v2/payments")
            .bodyValue(payment)
            .exchange()
            .expectStatus()
            .is5xxServerError()
    }

    suspend fun testUnsuccessfulPaymentRegistration3() {
        val customer = customerFinderUtil.find("123456789")
        val car = carFinderUtil.find("1234567890123456")
        val creditCard = creditCardFinderUtil.find("1234567890123456")
        val payment = Payment(customer, car, creditCard)
        webTestClient
            .post()
            .uri("api/v2/payments")
            .bodyValue(payment)
            .exchange()
            .expectStatus()
            .is5xxServerError()
    }

}