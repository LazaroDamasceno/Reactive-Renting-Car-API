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
private class AllCreditCardsDeletionByCustomerTest {

    @Autowired
    lateinit var webTestClient: WebTestClient

    @Order(1)
    @Test
    fun testSuccessfulAllCreditCardsDeletionByCustomer() {
        webTestClient
            .delete()
            .uri("api/v1/credit-cards/${123456789}")
            .exchange()
            .expectStatus()
            .is2xxSuccessful()
    }

    @Order(2)
    @Test
    fun testUnsuccessfulAllCreditCardsDeletionByCustomer() {
        webTestClient
            .delete()
            .uri("api/v1/credit-cards/${123456789}")
            .exchange()
            .expectStatus()
            .is5xxServerError()
    }

}