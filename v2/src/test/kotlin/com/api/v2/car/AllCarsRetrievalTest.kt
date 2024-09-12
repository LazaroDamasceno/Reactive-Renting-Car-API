package com.api.v2.car

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.reactive.server.WebTestClient

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
private class AllCarsRetrievalTest {

    @Autowired
    lateinit var webTestClient: WebTestClient

    @Test
    fun testIfCarHasElements() {
        webTestClient
            .get()
            .uri("api/v2/cars")
            .exchange()
            .expectStatus()
            .is2xxSuccessful()
    }

}