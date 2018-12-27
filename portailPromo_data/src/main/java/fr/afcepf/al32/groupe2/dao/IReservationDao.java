package fr.afcepf.al32.groupe2.dao;

import java.util.List;

import fr.afcepf.al32.groupe2.entity.Client;
import fr.afcepf.al32.groupe2.entity.Reservation;

public interface IReservationDao {
	Reservation findOne(Long idUnite);
	Reservation createOne(Reservation reservation);
	List<Reservation> findAll();
	List<Reservation> findAllByClient(Client client);
	Reservation getLastReservation(Client client);
	Reservation update(Reservation reservation);
}
