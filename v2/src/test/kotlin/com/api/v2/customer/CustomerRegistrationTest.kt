package com.api.v2.customer

import com.api.v2.customer.domain.Customer
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
private class CustomerRegistrationTest {

	@Autowired
	lateinit var webTestClient: WebTestClient

	val requestDto = Customer(
		"Leo",
		"",
		"Santos",
		"123456789",
		LocalDate.parse("2000-12-12"),
		"leosantos@gmail.com",
		"1234567890",
		"male"
	)

	@Test
	@Order(1)
	fun testSuccessfulCustomerRegistration() {
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
		webTestClient
			.post()
			.uri("api/v2/customers")
			.bodyValue(requestDto)
			.exchange()
			.expectStatus()
			.is5xxServerError()
	}

}
