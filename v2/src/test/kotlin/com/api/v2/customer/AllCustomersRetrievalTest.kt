package com.api.v2.customer


import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.reactive.server.WebTestClient

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AllCustomersRetrievalTest {

    @Autowired
    private lateinit var webTestClient: WebTestClient

    @Test
    fun testIfCustomerIsNotEmpty() {
        webTestClient
            .get()
            .uri("api/v1/customers/${123456789}")
            .exchange()
            .expectStatus()
            .is2xxSuccessful()
    }

}