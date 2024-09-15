package com.api.v1.rent;

import com.api.v1.dtos.CarRegistrationRequestDto;
import com.api.v1.dtos.CreditCardRegistrationRequestDto;
import com.api.v1.dtos.CustomerRegistrationRequestDto;
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
class RentRegistrationTest {

    @Autowired
    WebTestClient webTestClient;

    @Test
    @Order(1)
    void testSuccessfulCustomerRegistration() {
        var request = new CustomerRegistrationRequestDto(
                "Leo",
                "",
                "Santos",
                "123456789",
                LocalDate.parse("2000-12-12"),
                "leosantos@mail.net",
                "St. Dennis, Paris",
                "1234567890"
        );
        webTestClient
                .post()
                .uri("api/v1/customers")
                .bodyValue(request)
                .exchange()
                .expectStatus()
                .is2xxSuccessful();
    }

    @Test
    @Order(2)
    void testUnsuccessfulCustomerRegistration() {
        var request = new CustomerRegistrationRequestDto(
                "Leo",
                "",
                "Santos",
                "123456789",
                LocalDate.parse("2000-12-12"),
                "leosantos@mail.net",
                "St. Dennis, Paris",
                "1234567890"
        );
        webTestClient
                .post()
                .uri("api/v1/customers")
                .bodyValue(request)
                .exchange()
                .expectStatus()
                .is5xxServerError();
    }

    @Test
    @Order(3)
    void testSuccessfulCarRegistration() {
        var requestDto = new CarRegistrationRequestDto(
                "GM",
                "RAM",
                2024,
                "12345678901234567",
                "1234567"
        );
        webTestClient
                .post()
                .uri("api/v1/cars")
                .bodyValue(requestDto)
                .exchange()
                .expectStatus()
                .is2xxSuccessful();
    }

    @Test
    @Order(4)
    void testUnsuccessfulCarRegistration() {
        var requestDto = new CarRegistrationRequestDto(
                "GM",
                "RAM",
                2024,
                "12345678901234567",
                "1234567"
        );
        webTestClient
                .post()
                .uri("api/v1/cars")
                .bodyValue(requestDto)
                .exchange()
                .expectStatus()
                .is5xxServerError();
    }

    @Test
    @Order(5)
    void testSuccessfulCreditCardRegistration() {
        var requestDto = new CreditCardRegistrationRequestDto(
                "Leo Santos Jr.",
                "1234567890123456",
                "American Express",
                "343",
                LocalDate.parse("2032-12-12")
        );
        webTestClient
                .post()
                .uri("api/v1/credit-cards")
                .bodyValue(requestDto)
                .exchange()
                .expectStatus()
                .is2xxSuccessful();
    }

    @Test
    @Order(6)
    void testUnsuccessfulCreditCardRegistration() {
        var requestDto = new CreditCardRegistrationRequestDto(
                "Leo Santos Jr.",
                "1234567890123456",
                "American Express",
                "343",
                LocalDate.parse("2032-12-12")
        );
        webTestClient
                .post()
                .uri("api/v1/credit-cards")
                .bodyValue(requestDto)
                .exchange()
                .expectStatus()
                .is5xxServerError();
    }

    @Test
    @Order(7)
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

    @Test
    void testUnsuccessfulPaymentRegistration1() {
        var ssn = "123456788";
        var vin = "12345678901234567";
        var cardNumber = "1234567890123456";
        webTestClient
                .post()
                .uri("api/v1/payments/%s/%s/%s".formatted(ssn, vin, cardNumber))
                .exchange()
                .expectStatus()
                .is5xxServerError();
    }

    @Test
    void testUnsuccessfulPaymentRegistration2() {
        var ssn = "123456789";
        var vin = "12345678901234566";
        var cardNumber = "1234567890123456";
        webTestClient
                .post()
                .uri("api/v1/payments/%s/%s/%s".formatted(ssn, vin, cardNumber))
                .exchange()
                .expectStatus()
                .is5xxServerError();
    }

    @Test
    void testUnsuccessfulPaymentRegistration3() {
        var ssn = "123456789";
        var vin = "12345678901234567";
        var cardNumber = "1234567890123455";
        webTestClient
                .post()
                .uri("api/v1/payments/%s/%s/%s".formatted(ssn, vin, cardNumber))
                .exchange()
                .expectStatus()
                .is5xxServerError();
    }

    @Test
    @Order(8)
    void testSuccessfulRentRegistration() {
        var ssn = "123456789";
        var vin = "12345678901234567";
        var paymentOrderNumber = "20240001";
        webTestClient
                .post()
                .uri("api/v1/rents/%s/%s/%s".formatted(ssn, vin, paymentOrderNumber))
                .exchange()
                .expectStatus()
                .is2xxSuccessful();
    }

    @Test
    void testUnsuccessfulRentRegistration1() {
        var ssn = "123456788";
        var vin = "12345678901234567";
        var orderNumber = "20240001";
        webTestClient
                .post()
                .uri("api/v1/rents/%s/%s/%s".formatted(ssn, vin, orderNumber))
                .exchange()
                .expectStatus()
                .is5xxServerError();
    }

    @Test
    void testUnsuccessfulRentRegistration2() {
        var ssn = "123456789";
        var vin = "12345678901234566";
        var orderNumber = "20240001";
        webTestClient
                .post()
                .uri("api/v1/rents/%s/%s/%s".formatted(ssn, vin, orderNumber))
                .exchange()
                .expectStatus()
                .is5xxServerError();
    }

    @Test
    void testUnsuccessfulRentRegistration3() {
        var ssn = "123456789";
        var vin = "12345678901234567";
        var orderNumber = "20240000";
        webTestClient
                .post()
                .uri("api/v1/rents/%s/%s/%s".formatted(ssn, vin, orderNumber))
                .exchange()
                .expectStatus()
                .is5xxServerError();
    }

}