package fr.afcepf.al32.groupe2.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="reservation")
public class Reservation {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name="creation_date")
	@NotBlank
	private String dateCreation;
	@Column(name="retrait_code")
	@NotBlank
	private String codeRetrait;
	@ManyToOne(cascade= {CascadeType.PERSIST})
	@JoinColumn(name="client_id")
	@NotNull
	private Client client;
	@OneToOne(cascade= {CascadeType.PERSIST},mappedBy="reservation")
	private Evaluation evaluation;
	@OneToOne(cascade= {CascadeType.PERSIST},mappedBy="reservation")
	private ReservationProduct reservationProduct;
	public String getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}
	public String getCodeRetrait() {
		return codeRetrait;
	}
	public void setCodeRetrait(String codeRetrait) {
		this.codeRetrait = codeRetrait;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Evaluation getEvaluation() {
		return evaluation;
	}
	public void setEvaluation(Evaluation evaluation) {
		this.evaluation = evaluation;
	}
	public ReservationProduct getReservationProduct() {
		return reservationProduct;
	}
	public void setReservationProduct(ReservationProduct reservationProduct) {
		this.reservationProduct = reservationProduct;
	}
	public Long getId() {
		return id;
	}
	
	
}
