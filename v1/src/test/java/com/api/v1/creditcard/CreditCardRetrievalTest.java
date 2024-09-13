package com.api.v1.creditcard;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CreditCardRetrievalTest {

    @Autowired
    WebTestClient webTestClient;

    @Test
    void testIfCreditCardIsNotEmpty() {
        webTestClient.get()
                .uri("api/v1/credit-cars")
                .exchange()
                .expectStatus()
                .is2xxSuccessful();
    }

}
