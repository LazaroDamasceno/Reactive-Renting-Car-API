package com.api.v1.creditcard;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CreditCardDeletionTest {

    @Autowired
    WebTestClient webTestClient;

    @Test
    @Order(1)
    void testSuccessfulCreditCardDeletion() {
        webTestClient
                .delete()
                .uri("api/v1/credit-cars")
                .exchange()
                .expectStatus()
                .is2xxSuccessful();
    }

    @Test
    @Order(2)
    void testUnsuccessfulCreditCardDeletion() {
        webTestClient
                .delete()
                .uri("api/v1/credit-cars")
                .exchange()
                .expectStatus()
                .is5xxServerError();
    }

}
