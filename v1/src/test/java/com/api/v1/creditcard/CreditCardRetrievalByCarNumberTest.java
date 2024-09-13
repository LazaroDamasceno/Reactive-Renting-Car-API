package com.api.v1.creditcard;

import com.api.v1.creditcar.dtos.CreditCardRegistrationRequestDto;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.time.LocalDate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CreditCardRetrievalByCarNumberTest {

    @Autowired
    WebTestClient webTestClient;

    @Test
    @Order(1)
    void testSuccessfulCreditCardRetrievalByCardNumber() {
        webTestClient
                .get()
                .uri("api/v1/credit-cards/%16d".formatted(1234567890123456L))
                .exchange()
                .expectStatus()
                .is2xxSuccessful();
    }

    @Test
    @Order(2)
    void testUnsuccessfulCreditCardRetrievalByCardNumber() {
        webTestClient
                .get()
                .uri("api/v1/credit-cards/%16d".formatted(1234567890123455L))
                .exchange()
                .expectStatus()
                .is5xxServerError();
    }

}
