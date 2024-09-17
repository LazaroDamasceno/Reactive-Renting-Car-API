package com.api.v2.car

import com.api.v2.car.dtos.CarUpdateRequestDto
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.reactive.server.WebTestClient

@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
private class CarUpdateTest {

    @Autowired
    lateinit var webTestClient: WebTestClient

    private val requestDto = CarUpdateRequestDto(
        "RAM",
        "2024",
        "GM",
        "7654321"
    )

    @Test
    @Order(1)
    fun testSuccessfulCarUpdating() {
        val vin = "12345678901234567"
        webTestClient
            .put()
            .uri("api/v2/cars/${vin}")
            .bodyValue(requestDto)
            .exchange()
            .expectStatus()
            .is2xxSuccessful()
    }

    @Test
    @Order(2)
    fun testUnsuccessfulCarUpdating() {
        val vin = "12345678901234566"
        webTestClient
            .put()
            .uri("api/v2/cars/${vin}")
            .bodyValue(requestDto)
            .exchange()
            .expectStatus()
            .is5xxServerError()
    }

}