package com.api.v2.customer

import com.api.v2.customer.dtos.CustomerUpdateRequestDto
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
private class CustomerUpdateTest {

    @Autowired
    lateinit var webTestClient: WebTestClient

    private val requestDto = CustomerUpdateRequestDto(
        "Leo",
        "Silva",
        "Santos Jr.",
        LocalDate.parse("2000-01-12"),
        "jr@leosantos.com",
        "0987654321",
        "cis male"
    )

    @Test
    @Order(1)
    fun testSuccessfulCustomerUpdate() {
        val ssn = "123456789"
        webTestClient
            .put()
            .uri("api/v2/customers/$ssn")
            .bodyValue(requestDto)
            .exchange()
            .expectStatus()
            .is2xxSuccessful()
    }

    @Test
    @Order(2)
    fun testUnsuccessfulCustomerUpdate() {
        val ssn = "123456788"
        webTestClient
            .put()
            .uri("api/v2/customers/$ssn")
            .bodyValue(requestDto)
            .exchange()
            .expectStatus()
            .is5xxServerError()
    }

}