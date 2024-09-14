package com.api.v2.payment

import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.reactive.server.WebTestClient

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
private class AllPaymentRetrievalTest {

    @Autowired
    lateinit var webTestClient: WebTestClient

    @Test
    fun testSuccessfulAllPaymentsRetrieval() {
        webTestClient
            .get()
            .uri("api/v1/payments")
            .exchange()
            .expectStatus()
            .is2xxSuccessful()
    }

}