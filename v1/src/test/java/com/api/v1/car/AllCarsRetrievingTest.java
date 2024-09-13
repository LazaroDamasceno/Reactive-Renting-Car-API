package com.api.v1.car;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AllCarsRetrievingTest {

    @Autowired
    WebTestClient webTestClient;

    @Test
    void testIfCarHasElements() {
        webTestClient
                .get()
                .uri("api/v1/cars")
                .exchange()
                .expectStatus()
                .is2xxSuccessful();
    }

}
