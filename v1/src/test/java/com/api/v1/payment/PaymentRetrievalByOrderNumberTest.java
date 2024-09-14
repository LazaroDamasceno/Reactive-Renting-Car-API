package com.api.v1.payment;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PaymentRetrievalByOrderNumberTest {

    @Autowired
    WebTestClient webTestClient;

    @Test
    @Order(1)
    void testSuccessfulPaymentRegistration() {
        var ssn = "123456789";
        var vin = "12345678901234567";
        var cardNumber = "1234567890123456";
        webTestClient
                .post()
                .uri("api/v1/payments/%s/%s/%s".formatted(ssn, vin, cardNumber))
                .exchange()
                .expectStatus()
                .is2xxSuccessful();
    }

}
