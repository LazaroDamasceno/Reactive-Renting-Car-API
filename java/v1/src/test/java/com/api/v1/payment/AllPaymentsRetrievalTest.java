package com.api.v1.payment;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AllPaymentsRetrievalTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testIfPaymentIsNotEmpty() {
        webTestClient
                .get()
                .uri("api/v1/payments")
                .exchange()
                .expectStatus()
                .is2xxSuccessful();
    }

}
