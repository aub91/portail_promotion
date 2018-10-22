package fr.afcepf.al32.groupe2.web.client;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import fr.afcepf.al32.groupe2.entity.Client;
import fr.afcepf.al32.groupe2.entity.Reservation;
import fr.afcepf.al32.groupe2.service.IServiceReservation;
import fr.afcepf.al32.groupe2.web.connexion.ConnectionBean;

@Component
@SessionScope
@Transactional
public class ClientBean {
	
	@Autowired
	private ConnectionBean connectionBean;
	
	@Autowired
	private IServiceReservation serviceReservation;
	
	private List<Reservation> bookList;

	public List<Reservation> getBookList() {
		Client client = (Client) connectionBean.getLoggedUser();

		return serviceReservation.findAllByClient(client);
	}

	public void setBookList(List<Reservation> bookList) {
		this.bookList = bookList;
	}
	
	
}
