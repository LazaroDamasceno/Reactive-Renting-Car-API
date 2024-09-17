package com.api.v2.car

import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.reactive.server.WebTestClient

@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
private class CarRetrievalByVinTest {

    @Autowired
    lateinit var webTestClient: WebTestClient

    @Test
    @Order(1)
    fun testSuccessfulCarRetrieval() {
        val vin = "12345678901234567"
        webTestClient
            .get()
            .uri("api/v2/cars/$vin")
            .exchange()
            .expectStatus()
            .is2xxSuccessful()
    }

    @Test
    @Order(2)
    fun testUnsuccessfulCarRetrieval() {
        val vin = "12345678901234566"
        webTestClient
            .get()
            .uri("api/v2/cars/$vin")
            .exchange()
            .expectStatus()
            .is5xxServerError()
    }

}