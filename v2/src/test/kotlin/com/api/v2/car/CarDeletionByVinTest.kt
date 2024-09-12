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
private class CarDeletionByVinTest {

    @Autowired
    private lateinit var webTestClient: WebTestClient

    @Test
    @Order(1)
    fun testSuccessfulCarDeletionByVin() {
        val vin = "12345678901234567"
        webTestClient
            .delete()
            .uri("api/v2/cars/$vin")
            .exchange()
            .expectStatus()
            .is2xxSuccessful()
    }

    @Test
    @Order(2)
    fun testUnsuccessfulCarDeletionByVin() {
        val vin = "12345678901234567"
        webTestClient
            .delete()
            .uri("api/v2/cars/$vin")
            .exchange()
            .expectStatus()
            .is5xxServerError()
    }

}