package com.api.v1.customer;

import com.api.v1.dtos.CustomerUpdatingRequestDto;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.time.LocalDate;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CustomerUpdatingTest {

    @Autowired
    WebTestClient webTestClient;

    @Order(1)
    @Test
    void testSuccessfulCustomerUpdating() {
        var requestDto = new CustomerUpdatingRequestDto(
                "Leonard",
                "Silva",
                "Santos Jr.",
                LocalDate.parse("2000-12-12"),
                "jr@leosantos.com",
                "National Diet, Tokyo, Japan",
                "0987654321"
        );
        webTestClient
                .put()
                .uri("api/v1/customers/%s".formatted("123456789"))
                .bodyValue(requestDto)
                .exchange()
                .expectStatus()
                .is2xxSuccessful();
    }

    @Order(2)
    @Test
    void testUnsuccessfulCustomerUpdating() {
        var requestDto = new CustomerUpdatingRequestDto(
                "Leonard",
                "Silva",
                "Santos Jr.",
                LocalDate.parse("2000-12-12"),
                "jr@leosantos.com",
                "National Diet, Tokyo, Japan",
                "0987654321"
        );
        webTestClient
                .put()
                .uri("api/v1/customers/%s".formatted("123456788"))
                .bodyValue(requestDto)
                .exchange()
                .expectStatus()
                .is5xxServerError();
    }

}
