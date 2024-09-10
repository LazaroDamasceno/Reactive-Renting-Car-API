package com.api.v1.car;

import com.api.v1.car.dtos.CarUpdatingRequestDto;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@TestMethodOrder((MethodOrderer.OrderAnnotation.class))
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CarUpdatingTest {

    @Autowired
    private WebTestClient webTestClient;

    @Order(1)
    @Test
    void testSuccessfulCarUpdating() {
        var requestDto = new CarUpdatingRequestDto(
                "GM",
                "RAM 1000",
                2024,
                "7654321"
        );
        webTestClient
                .put()
                .uri("api/v1/cars/%s".formatted("12345678901234567"))
                .bodyValue(requestDto)
                .exchange()
                .expectStatus()
                .is2xxSuccessful();
    }

    @Order(2)
    @Test
    void testUnsuccessfulCarUpdating1() {
        var requestDto = new CarUpdatingRequestDto(
                "GM",
                "RAM 1000",
                2024,
                "7654321"
        );
        webTestClient
                .put()
                .uri("api/v1/cars/%s".formatted("12345678901234566"))
                .bodyValue(requestDto)
                .exchange()
                .expectStatus()
                .is5xxServerError();
    }

    @Order(3)
    @Test
    void testUnsuccessfulCarUpdating2() {
        var requestDto = new CarUpdatingRequestDto(
                "GM",
                "RAM 1000",
                2024,
                "1234567"
        );
        webTestClient
                .put()
                .uri("api/v1/cars/%s".formatted("12345678901234567"))
                .bodyValue(requestDto)
                .exchange()
                .expectStatus()
                .is5xxServerError();
    }

}
