package com.api.v1;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CustomersRetrievingBySsnTest {

    @Autowired
    WebTestClient webTestClient;

    @Order(1)
    @Test
    void testSuccessfulCustomerRetrievingBySSn() {
        webTestClient
                .get()
                .uri("api/v1/customers/%s".formatted("123456789"))
                .exchange()
                .expectStatus()
                .is2xxSuccessful();
    }

    @Order(2)
    @Test
    void testUnsuccessfulCustomerRetrievingBySSn() {
        webTestClient
                .get()
                .uri("api/v1/customers/%s".formatted("123456788"))
                .exchange()
                .expectStatus()
                .is5xxServerError();
    }


}
