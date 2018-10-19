package fr.afcepf.al32.groupe2.service;

import java.util.List;

import fr.afcepf.al32.groupe2.entity.BaseProduct;
import fr.afcepf.al32.groupe2.entity.Reservation;


public interface IServiceReservation {


List<Reservation> findAll();
BaseProduct rechercheReservationParIdentifiant(Long idUnite);
BaseProduct AjouterReservation(Reservation reservation);

}
