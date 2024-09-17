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
class CarDeletionByVinTest {

    @Autowired
    WebTestClient webTestClient;

    String vin = "12345678901234567";

    @Test
    @Order(1)
    void testSuccessfulCarDeletion() {
        webTestClient
                .delete()
                .uri("api/v1/cars/%s".formatted(vin))
                .exchange()
                .expectStatus()
                .is2xxSuccessful();
    }

    @Test
    @Order(2)
    void testUnsuccessfulCarDeletion() {
        webTestClient
                .delete()
                .uri("api/v1/cars/%s".formatted(vin))
                .exchange()
                .expectStatus()
                .is5xxServerError();
    }

}
