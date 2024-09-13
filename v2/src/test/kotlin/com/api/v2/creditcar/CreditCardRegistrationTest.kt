package com.api.v2.creditcar

import com.api.v2.creditcard.domain.CreditCard
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.reactive.server.WebTestClient
import java.time.LocalDate

@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
private class CreditCardRegistrationTest {

    @Autowired
    lateinit var webTestClient: WebTestClient

    val requestDto = CreditCard(
        "Leo Santos Jr.",
        "1234567890123456",
        "American Express",
        "344",
        LocalDate.parse("2032-09-12")
    )

    @Order(1)
    @Test
    fun testSuccessfulCreditCardRegistration() {
        webTestClient
            .post()
            .uri("api/v2/credit-cards")
            .bodyValue(requestDto)
            .exchange()
            .expectStatus()
            .is2xxSuccessful()
    }

    @Order(2)
    @Test
    fun testUnsuccessfulCreditCardRegistration() {
        webTestClient
            .post()
            .uri("api/v2/credit-cards")
            .bodyValue(requestDto)
            .exchange()
            .expectStatus()
            .is5xxServerError()
    }

}