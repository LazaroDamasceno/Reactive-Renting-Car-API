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
class CustomerRegistrationTest {

	@Autowired
	private WebTestClient webTestClient;

	@Test
	@Order(1)
	void testSuccessfulCustomerRegistration() {
		webTestClient
				.post()
				.uri("api/v1/customers")
				//.bodyValue()
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
				//.bodyValue()
				.exchange()
				.expectStatus()
				.is5xxServerError();
	}

}
