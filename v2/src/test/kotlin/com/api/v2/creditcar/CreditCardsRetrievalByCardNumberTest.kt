package com.api.v2.creditcar

import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.reactive.server.WebTestClient

@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
private class CreditCardsRetrievalByCardNumberTest {

    @Autowired
    lateinit var webTestClient: WebTestClient

    @Test
    @Order(1)
    fun testSuccessfulCreditCardRetrieval() {
        val cardNumber = "1234567890123456"
        webTestClient
            .get()
            .uri("api/v2/credit-cards/$cardNumber")
            .exchange()
            .expectStatus()
            .is2xxSuccessful()
    }

    @Test
    @Order(2)
    fun testUnsuccessfulCreditCardRetrieval() {
        val cardNumber = "1234567890123455"
        webTestClient
            .get()
            .uri("api/v2/credit-cards/$cardNumber")
            .exchange()
            .expectStatus()
            .is5xxServerError()
    }

}