package fr.afcepf.al32.groupe2.web.productlist;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import fr.afcepf.al32.groupe2.entity.Client;
import fr.afcepf.al32.groupe2.entity.Promotion;
import fr.afcepf.al32.groupe2.entity.Reservation;
import fr.afcepf.al32.groupe2.entity.ReservationProduct;
import fr.afcepf.al32.groupe2.service.IServiceReservation;
import fr.afcepf.al32.groupe2.web.connexion.ConnectionBean;

@Component
@Transactional
@RequestScope
public class BookBean {
	
	@Autowired
	ConnectionBean connectionBean;
	
	@Autowired
	IServiceReservation reservationService;
	
	private Double quantityBooked;
	
	public void book(Promotion promotion) {
		Reservation reservation = new Reservation();
		
		ReservationProduct reservationProduct = new ReservationProduct();
		reservationProduct.setBaseProducts(promotion.getBaseProduct());
		reservationProduct.setQuantityRequested(quantityBooked);
		
		reservation.setClient((Client)connectionBean.getLoggedUser());
		reservation.setDateCreation(new Date());
		reservation.setWithdrawalCode("12345");
		reservation.setReservationProduct(reservationProduct);
		
		reservationService.ajouterReservation(reservation);
	}

	public Double getQuantityBooked() {
		return quantityBooked;
	}

	public void setQuantityBooked(Double quantityBooked) {
		this.quantityBooked = quantityBooked;
	}
	
	
}
