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
private class AllCreditCardsDeletionTest {

    @Autowired
    lateinit var webTestClient: WebTestClient

    @Order(1)
    @Test
    fun testSuccessfulAllCreditCardsDeletion() {
        webTestClient
            .delete()
            .uri("api/v2/credit-cards")
            .exchange()
            .expectStatus()
            .is2xxSuccessful()
    }

    @Order(2)
    @Test
    fun testUnsuccessfulAllCreditCardsDeletion() {
        webTestClient
            .delete()
            .uri("api/v2/credit-cards")
            .exchange()
            .expectStatus()
            .is5xxServerError()
    }

}