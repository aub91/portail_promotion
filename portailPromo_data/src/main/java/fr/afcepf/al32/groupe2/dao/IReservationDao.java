package fr.afcepf.al32.groupe2.dao;

import java.util.List;

import fr.afcepf.al32.groupe2.entity.Reservation;

public interface IReservationDao {
	Reservation findOne(Long idUnite);
	Reservation createOne(Reservation reservation);
	List<Reservation> findAll();
}
