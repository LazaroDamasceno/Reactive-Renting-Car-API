package com.api.v1.car;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CarRegistrationTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    @Order(1)
    void testSuccessfulCarRegistration() {
        webTestClient
                .post()
                .uri("api/v1/cars")
                //.bodyValue()
                .exchange()
                .expectStatus()
                .is2xxSuccessful();
    }

    @Test
    @Order(2)
    void testUnsuccessfulCarRegistration() {
        webTestClient
                .post()
                .uri("api/v1/cars")
                //.bodyValue()
                .exchange()
                .expectStatus()
                .is5xxServerError();
    }

}
