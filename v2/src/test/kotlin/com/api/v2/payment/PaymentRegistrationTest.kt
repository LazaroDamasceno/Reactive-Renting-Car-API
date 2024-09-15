package com.api.v2.payment

import com.api.v2.car.dtos.CarRegistrationRequestDto
import com.api.v2.creditcard.domain.CreditCard
import com.api.v2.customer.dtos.CustomerRegistrationRequestDto
import org.junit.jupiter.api.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.reactive.server.WebTestClient
import java.time.LocalDate

@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
private class PaymentRegistrationTest {

    @Autowired
    lateinit var webTestClient: WebTestClient

    @Test
    @Order(1)
    fun testSuccessfulCustomerRegistration() {
        val requestDto = CustomerRegistrationRequestDto(
            "Leo",
            "",
            "Santos",
            "123456789",
            LocalDate.parse("2000-12-12"),
            "leosantos@gmail.com",
            "1234567890",
            "male"
        )
        webTestClient
            .post()
            .uri("api/v2/customers")
            .bodyValue(requestDto)
            .exchange()
            .expectStatus()
            .is2xxSuccessful()
    }

    @Test
    @Order(2)
    fun testUnsuccessfulCustomerRegistration() {
        val requestDto = CustomerRegistrationRequestDto(
            "Leo",
            "",
            "Santos",
            "123456789",
            LocalDate.parse("2000-12-12"),
            "leosantos@gmail.com",
            "1234567890",
            "male"
        )
        webTestClient
            .post()
            .uri("api/v2/customers")
            .bodyValue(requestDto)
            .exchange()
            .expectStatus()
            .is5xxServerError()
    }

    @Test
    @Order(3)
    fun testSuccessfulCarRegistration() {
        val requestDto = CarRegistrationRequestDto(
            "12345678901234567",
            "RAM",
            "2024",
            "GM",
            "1234567"
        )
        webTestClient
            .post()
            .uri("api/v2/cars")
            .bodyValue(requestDto)
            .exchange()
            .expectStatus()
            .is2xxSuccessful()
    }

    @Test
    @Order(4)
    fun testUnsuccessfulCarRegistration() {
        val requestDto = CarRegistrationRequestDto(
            "12345678901234567",
            "RAM",
            "2024",
            "GM",
            "1234567"
        )
        webTestClient
            .post()
            .uri("api/v2/cars")
            .bodyValue(requestDto)
            .exchange()
            .expectStatus()
            .is5xxServerError()
    }

    @Order(5)
    @Test
    fun testSuccessfulCreditCardRegistration() {
        val requestDto = CreditCard(
            "Leo Santos Jr.",
            "1234567890123456",
            "American Express",
            "344",
            LocalDate.parse("2032-09-12")
        )
        webTestClient
            .post()
            .uri("api/v2/credit-cards")
            .bodyValue(requestDto)
            .exchange()
            .expectStatus()
            .is2xxSuccessful()
    }

    @Order(6)
    @Test
    fun testUnsuccessfulCreditCardRegistration() {
        val requestDto = CreditCard(
            "Leo Santos Jr.",
            "1234567890123456",
            "American Express",
            "344",
            LocalDate.parse("2032-09-12")
        )
        webTestClient
            .post()
            .uri("api/v2/credit-cards")
            .bodyValue(requestDto)
            .exchange()
            .expectStatus()
            .is5xxServerError()
    }

    @Test
    @Order(7)
    fun testSuccessfulPaymentRegistration() {
        val ssn = "123456789"
        val vin = "12345678901234567"
        val cardNumber = "1234567890123456"
        webTestClient
            .post()
            .uri("api/v2/payments/$ssn/$vin/$cardNumber")
            .exchange()
            .expectStatus()
            .is2xxSuccessful()
    }

    @Test
    fun testUnsuccessfulPaymentRegistration1() {
        val ssn = "123456788"
        val vin = "12345678901234567"
        val cardNumber = "1234567890123456"
        webTestClient
            .post()
            .uri("api/v2/payments/$ssn/$vin/$cardNumber")
            .exchange()
            .expectStatus()
            .is5xxServerError()
    }

    @Test
    fun testUnsuccessfulPaymentRegistration2() {
        val ssn = "123456789"
        val vin = "12345678901234566"
        val cardNumber = "1234567890123456"
        webTestClient
            .post()
            .uri("api/v2/payments/$ssn/$vin/$cardNumber")
            .exchange()
            .expectStatus()
            .is5xxServerError()
    }

    @Test
    fun testUnsuccessfulPaymentRegistration3() {
        val ssn = "123456789"
        val vin = "12345678901234567"
        val cardNumber = "1234567890123455"
        webTestClient
            .post()
            .uri("api/v2/payments/$ssn/$vin/$cardNumber")
            .exchange()
            .expectStatus()
            .is5xxServerError()
    }

}