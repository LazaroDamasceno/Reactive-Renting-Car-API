package com.api.v2.customer

import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.reactive.server.WebTestClient

@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AllCustomersDeletionTest {

    @Autowired
    private lateinit var webTestClient: WebTestClient

    @Test
    @Order(1)
    fun testSuccessfulAllCustomersDeletion() {
        webTestClient
            .delete()
            .uri("api/v1/customers")
            .exchange()
            .expectStatus()
            .is2xxSuccessful()
    }

    @Test
    @Order(2)
    fun testUnsuccessfulAllCustomersDeletion() {
        webTestClient
            .delete()
            .uri("api/v1/customers")
            .exchange()
            .expectStatus()
            .is5xxServerError()
    }

}