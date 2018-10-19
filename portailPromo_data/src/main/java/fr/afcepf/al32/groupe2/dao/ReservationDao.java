package fr.afcepf.al32.groupe2.dao;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import fr.afcepf.al32.groupe2.entity.BaseProduct;
import fr.afcepf.al32.groupe2.entity.Client;
import fr.afcepf.al32.groupe2.entity.Evaluation;
import fr.afcepf.al32.groupe2.entity.Reservation;

@Transactional
@Component
public class ReservationDao implements IReservationDao {

	
	
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	private Long id;
//	@Column(name="creation_date")
//	@NotBlank
//	private String dateCreation;
//	@Column(name="retrait_code")
//	@NotBlank
//	private String codeRetrait;
//	@ManyToOne(cascade= {CascadeType.PERSIST})
//	@JoinColumn(name="client_id")
//	@NotNull
//	private Client client;
//	@OneToOne(cascade= {CascadeType.PERSIST},mappedBy="reservation")
//	private Evaluation evaluation;
//	@OneToOne(cascade= {CascadeType.PERSIST},mappedBy="reservation")
//	
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
		
		return  entityManager.createNamedQuery("Reservation.findAll",Reservation.class).getResultList();
	}

}
