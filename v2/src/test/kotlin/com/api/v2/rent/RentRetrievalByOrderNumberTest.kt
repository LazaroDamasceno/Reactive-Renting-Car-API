package com.api.v2.rent

import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.reactive.server.WebTestClient

@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
private class RentRetrievalByOrderNumberTest {

    @Autowired
    lateinit var webTestClient: WebTestClient

    @Test
    @Order(1)
    fun testSuccessfulRetrieval() {
        val orderNumber = "20240001"
        webTestClient
            .get()
            .uri("api/v2/rents/$orderNumber")
            .exchange()
            .expectStatus()
            .is2xxSuccessful()
    }

    @Test
    fun testUnsuccessfulRetrieval() {
        val orderNumber = "20240000"
        webTestClient
            .get()
            .uri("api/v2/rents/$orderNumber")
            .exchange()
            .expectStatus()
            .is5xxServerError()
    }

}