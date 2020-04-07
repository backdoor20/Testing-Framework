package com.backdoor20.spring.springjunit.dao;

import org.springframework.stereotype.Component;

import com.backdoor20.spring.springjunit.dao.dto.Ticket;


@Component
public class TicketDAOImpl implements TicketDAO {

	public int createTicket(Ticket ticket) {
		
		return 1;
	}

}
