package fr.afcepf.al32.groupe2.service;

import java.util.List;

import fr.afcepf.al32.groupe2.entity.Client;
import fr.afcepf.al32.groupe2.entity.Reservation;
import fr.afcepf.al32.groupe2.entity.Shopkeeper;


public interface IServiceReservation {

List<Reservation> findAll();
Reservation rechercheReservationParIdentifiant(Long idUnite);
Reservation ajouterReservation(Reservation reservation);
List<Reservation> findAllByClient(Client client);
List<Reservation> findAllByShopKeeper(Shopkeeper shopkeeper);

    Reservation update(Reservation reservation);
}
