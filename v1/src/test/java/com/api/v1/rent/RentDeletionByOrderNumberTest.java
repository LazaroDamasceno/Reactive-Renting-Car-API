package com.api.v1.rent;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@TestMethodOrder((MethodOrderer.OrderAnnotation.class))
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RentDeletionByOrderNumberTest {

    @Autowired
    WebTestClient webTestClient;

    @Test
    @Order(1)
    void testSuccessfulDeletionByOrderNumber() {
        webTestClient
                .get()
                .uri("api/v1/rents/%08d".formatted(20240001))
                .exchange()
                .expectStatus()
                .is2xxSuccessful();
    }

    @Test
    void testUnsuccessfulDeletionByOrderNumber() {
        webTestClient
                .get()
                .uri("api/v1/rents/%08d".formatted(20240000))
                .exchange()
                .expectStatus()
                .is5xxServerError();
    }


}
