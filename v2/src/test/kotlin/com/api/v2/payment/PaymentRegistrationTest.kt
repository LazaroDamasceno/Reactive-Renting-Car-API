package com.api.v2.payment

import org.junit.jupiter.api.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.reactive.server.WebTestClient

@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
private class PaymentRegistrationTest {

    @Autowired
    lateinit var webTestClient: WebTestClient

    @Test
    @Order(1)
    fun testSuccessfulPaymentRegistration() {
        val ssn = "123456789"
        val vin = "12345678901234567"
        val cardNumber = "1234567890123456"
        webTestClient
            .post()
            .uri("api/v2/payments/$ssn/$vin/$cardNumber")
            .exchange()
            .expectStatus()
            .is2xxSuccessful()
    }

    @Test
    fun testUnsuccessfulPaymentRegistration1() {
        val ssn = "123456788"
        val vin = "12345678901234567"
        val cardNumber = "1234567890123456"
        webTestClient
            .post()
            .uri("api/v2/payments/$ssn/$vin/$cardNumber")
            .exchange()
            .expectStatus()
            .is5xxServerError()
    }

    @Test
    fun testUnsuccessfulPaymentRegistration2() {
        val ssn = "123456789"
        val vin = "12345678901234566"
        val cardNumber = "1234567890123456"
        webTestClient
            .post()
            .uri("api/v2/payments/$ssn/$vin/$cardNumber")
            .exchange()
            .expectStatus()
            .is5xxServerError()
    }

    @Test
    fun testUnsuccessfulPaymentRegistration3() {
        val ssn = "123456789"
        val vin = "12345678901234567"
        val cardNumber = "1234567890123455"
        webTestClient
            .post()
            .uri("api/v2/payments/$ssn/$vin/$cardNumber")
            .exchange()
            .expectStatus()
            .is5xxServerError()
    }

}