package fr.afcepf.al32.groupe2.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.afcepf.al32.groupe2.dao.IReservationDao;
import fr.afcepf.al32.groupe2.entity.Client;
import fr.afcepf.al32.groupe2.entity.Reservation;
import fr.afcepf.al32.groupe2.service.IServiceReservation;

@Component
@Transactional
public class ServiceReservation implements IServiceReservation {
	
	@Autowired
	private IReservationDao reservationDao;

	@Override
	public List<Reservation> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reservation rechercheReservationParIdentifiant(Long idUnite) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reservation ajouterReservation(Reservation reservation) {
		// TODO Auto-generated method stub
		return reservationDao.createOne(reservation);
	}

	@Override
	public List<Reservation> findAllByClient(Client client) {
		// TODO Auto-generated method stub
		return reservationDao.findAllByClient(client);
	}

}
