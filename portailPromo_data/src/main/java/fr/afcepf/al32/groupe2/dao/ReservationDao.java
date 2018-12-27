package fr.afcepf.al32.groupe2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import fr.afcepf.al32.groupe2.entity.Client;
import fr.afcepf.al32.groupe2.entity.Reservation;

@Transactional
@Component
public class ReservationDao implements IReservationDao {

	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public Reservation findOne(Long idUnite) {
		return entityManager.find(Reservation.class, idUnite);
	}
	

	@Override
	public Reservation createOne(Reservation reservation) {
		entityManager.persist(reservation);
		return reservation;
	
	}


	@Override
	public List<Reservation> findAll() {
		
		return entityManager.createNamedQuery("Reservation.findAll",Reservation.class).getResultList();
	}


	@Override
	public List<Reservation> findAllByClient(Client client) {
		return entityManager.createNamedQuery("Reservation.findAllByClient",Reservation.class).setParameter("clientId", client.getId()).getResultList();
	}

	@Override
	public Reservation update(Reservation reservation) {

		return entityManager.merge(reservation);
	}


	@Override
	public Reservation getLastReservation(Client client) {
	 return entityManager.createNamedQuery("Reservation.findAllByClientOrderByDate",Reservation.class)
			 .setParameter("clientId", client.getId()).getResultList().get(0);
		
	}

}
