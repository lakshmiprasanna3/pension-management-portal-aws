package com.cognizant.ms.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
 class AuthRequestTest {

	@Test
	void beanCreationTest() {
		assertNotNull(new AuthRequest());
	}

	@Test
	void noArgsConstructorTest() {
		AuthRequest authRequest = new AuthRequest();
		assertNotNull(authRequest);
	}

	@Test
	void AllArgsConstructorTest() {
		AuthRequest authRequest = new AuthRequest("Prasanna", "pwd1");
		assertNotNull(authRequest);
	}

	@Test
	void settersTest() {
		AuthRequest authRequest = new AuthRequest();
		authRequest.setPassword("Prasanna");
		authRequest.setUserName("pwd1");
		assertNotNull(authRequest) ;
	}

	@Test
	void gettersTest() {
		AuthRequest authRequest = new AuthRequest("Prasanna", "pwd1");
		assertEquals("Prasanna", authRequest.getUserName());
		assertEquals("pwd1", authRequest.getPassword());
	}

}
