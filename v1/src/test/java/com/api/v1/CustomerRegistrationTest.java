package com.api.v1;

import com.api.v1.customer.dtos.CustomerRegistrationRequestDto;
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
class CustomerRegistrationTest {

	@Autowired
	private WebTestClient webTestClient;

	private CustomerRegistrationRequestDto request = new CustomerRegistrationRequestDto(
			"Leo",
			"",
			"Santos",
			"123456789",
			LocalDate.parse("2000-12-12"),
			"leosantos@mail.net",
			"St. Dennis, Paris",
			"1234567890"
	);

	@Test
	@Order(1)
	void testSuccessfulCustomerRegistration() {
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
		webTestClient
				.post()
				.uri("api/v1/customers")
				.bodyValue(request)
				.exchange()
				.expectStatus()
				.is5xxServerError();
	}

}
