package com.backdoor20.spring.springjunit.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.backdoor20.spring.springjunit.dao.TicketDAO;
import com.backdoor20.spring.springjunit.dao.dto.Ticket;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context.xml")
public class TicketServiceImplTest {

	private static final int RESULT = 1;
	private static final String PASSENGER_MOBILE = "1234567890";
	private static final String PASSENGER_NAME = "Bhupi";

	@Mock
	TicketDAO dao;

	@Autowired
	@InjectMocks
	private TicketServiceImpl service;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void buyTicketShouldReturnVaildValue() {

		when(dao.createTicket(any(Ticket.class))).thenReturn(1);
		int result = service.buyTicket(PASSENGER_NAME, PASSENGER_MOBILE);
		assertEquals(RESULT, result);
	}

}
