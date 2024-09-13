package com.api.v1.creditcard;

import com.api.v1.dtos.CreditCardRegistrationRequestDto;
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
class CreditCardRegistrationTest {

    @Autowired
    WebTestClient webTestClient;

    CreditCardRegistrationRequestDto requestDto = new CreditCardRegistrationRequestDto(
            "Leo Santos Jr.",
            "1234567890123456",
            "American Express",
            "343",
            LocalDate.parse("2032-12-12")
    );

    @Test
    @Order(1)
    void testSuccessfulCreditCardRegistration() {
        webTestClient
                .post()
                .uri("api/v1/credit-cards")
                .bodyValue(requestDto)
                .exchange()
                .expectStatus()
                .is2xxSuccessful();
    }

    @Test
    @Order(2)
    void testUnsuccessfulCreditCardRegistration() {
        webTestClient
                .post()
                .uri("api/v1/credit-cards")
                .bodyValue(requestDto)
                .exchange()
                .expectStatus()
                .is5xxServerError();
    }

}
