package com.backdoor20.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GreetingImplTest {

	private Greeting greeting;


	@BeforeEach
	public void setup() {
		greeting = new GreetingImpl();
	}
	
	@Test
	void greetShouldReturnValidOutput() {
		String result=greeting.greet("Junit");
		assertNotNull(result);
		assertEquals("Hello Junit", result);
	}
	

	@Test()
	void greetShouldThroughExcepttionNameIsBlank() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> greeting.greet(""));
	}
	
	@AfterEach
	public void tearDown() {
		greeting=null;
	}

}
