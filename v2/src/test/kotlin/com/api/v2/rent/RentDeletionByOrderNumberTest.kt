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
private class RentDeletionByOrderNumberTest {

    @Autowired
    lateinit var webTestClient: WebTestClient

    @Test
    @Order(1)
    fun testSuccessfulDeletion() {
        webTestClient
            .delete()
            .uri("api/v2/rents/${2024001}")
            .exchange()
            .expectStatus()
            .is2xxSuccessful()
    }

    @Test
    fun testUnsuccessfulDeletion() {
        webTestClient
            .delete()
            .uri("api/v2/rents/${2024000}")
            .exchange()
            .expectStatus()
            .is5xxServerError()
    }

}