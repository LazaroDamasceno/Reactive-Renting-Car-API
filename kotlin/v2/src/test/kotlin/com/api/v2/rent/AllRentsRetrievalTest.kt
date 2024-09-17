package com.api.v2.rent

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.reactive.server.WebTestClient

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
private class AllRentsRetrievalTest {

    @Autowired
    lateinit var webTestClient: WebTestClient

    @Test
    fun testIfRntIsEmpty() {
        webTestClient
            .get()
            .uri("api/v2/rents")
            .exchange()
            .expectStatus()
            .is2xxSuccessful()
    }

}