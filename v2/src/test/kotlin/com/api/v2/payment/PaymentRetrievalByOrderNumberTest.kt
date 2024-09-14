package com.api.v2.payment

import  org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.reactive.server.WebTestClient

@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
private class PaymentRetrievalByOrderNumberTest {

    @Autowired
    lateinit var webTestClient: WebTestClient

    @Test
    @Order(1)
    fun testSuccessfulPaymentRetrieval() {
        webTestClient
            .get()
            .uri("api/v1/payments/${20240001}")
            .exchange()
            .expectStatus()
            .is2xxSuccessful()
    }

    @Test
    fun testUnsuccessfulPaymentRetrieval() {
        webTestClient
            .get()
            .uri("api/v1/payments/${20240002}")
            .exchange()
            .expectStatus()
            .is5xxServerError()
    }

}