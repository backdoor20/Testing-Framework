package com.backdoor20.spring.springjunit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.backdoor20.spring.springjunit.dao.TicketDAO;
import com.backdoor20.spring.springjunit.dao.dto.Ticket;


@Component
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketDAO dao;
	
	public int buyTicket(String passengerName, String phone) {
		 Ticket ticket = new Ticket();
		 ticket.setPassengerName(passengerName);
		 ticket.setPhone(phone);
		getDao().createTicket(ticket);
		return 1;
	}

	public TicketDAO getDao() {
		return dao;
	}

	public void setDao(TicketDAO dao) {
		this.dao = dao;
	}

}
