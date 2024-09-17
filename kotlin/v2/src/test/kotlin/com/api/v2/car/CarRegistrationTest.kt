package com.api.v2.car

import com.api.v2.car.domain.Car
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.reactive.server.WebTestClient

@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
private class CarRegistrationTest {

    @Autowired
    lateinit var webTestClient: WebTestClient

    private val car = Car(
        "12345678901234567",
        "RAM",
        "2024",
        "GM",
        "1234567"
    )

    @Test
    @Order(1)
    fun testSuccessfulCarRegistration() {
        webTestClient
            .post()
            .uri("api/v2/cars")
            .bodyValue(car)
            .exchange()
            .expectStatus()
            .is2xxSuccessful()
    }

    @Test
    @Order(2)
    fun testUnsuccessfulCarRegistration() {
        webTestClient
            .post()
            .uri("api/v2/cars")
            .bodyValue(car)
            .exchange()
            .expectStatus()
            .is5xxServerError()
    }

}