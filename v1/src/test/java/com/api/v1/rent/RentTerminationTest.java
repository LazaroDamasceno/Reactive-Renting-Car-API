package com.api.v1.rent;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RentTerminationTest {

    @Autowired
    WebTestClient webTestClient;

    @Test
    @Order(1)
    void testSuccessfulTermination() {
        webTestClient
                .patch()
                .uri("api/v1/rents/%s".formatted("20240001"))
                .exchange()
                .expectStatus()
                .is2xxSuccessful();
    }

    @Test
    @Order(1)
    void testUnsuccessfulTermination() {
        webTestClient
                .patch()
                .uri("api/v1/rents/%s".formatted("20240001"))
                .exchange()
                .expectStatus()
                .is5xxServerError();
    }

}
