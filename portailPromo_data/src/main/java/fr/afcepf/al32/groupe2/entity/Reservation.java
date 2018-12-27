package fr.afcepf.al32.groupe2.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="reservation")
@NamedQueries({
	@NamedQuery(name="Reservation.findAll" , query="select r From Reservation r" ),
	@NamedQuery(name="Reservation.findAllByClient" , query="select r From Reservation r INNER JOIN r.client cli WHERE cli.id = :clientId" ),
	@NamedQuery(name="Reservation.findAllByShopKeeper" , query="select r From Reservation r INNER JOIN r.reservationProduct rp INNER JOIN rp.promotion p WHERE some indices(p.shops) IN :shopkeeperShopsId"),
	@NamedQuery(name="Reservation.findAllByClientOrderByDate" , query="select r From Reservation r INNER JOIN r.client cli WHERE cli.id = :clientId ORDER BY r.dateCreation DESC" )
})
public class Reservation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="creation_date")
	@NotNull
	private Date dateCreation;
	
	@Column(name="withdrawal_code")
	@NotBlank
	private String withdrawalCode;
	
	@ManyToOne(cascade= {CascadeType.MERGE})
	@JoinColumn(name="client_id")
	@NotNull
	private Client client;
	
	@OneToOne(cascade= {CascadeType.PERSIST},mappedBy="reservation")
	private Evaluation evaluation;
	
	@OneToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE},mappedBy="reservation", fetch=FetchType.EAGER)
	private ReservationProduct reservationProduct;
	
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(@NotBlank Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	
	public String getWithdrawalCode() {
		return withdrawalCode;
	}
	public void setWithdrawalCode(String withdrawalCode) {
		this.withdrawalCode = withdrawalCode;
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
		reservationProduct.setReservation(this);
	}
	public Long getId() {
		return id;
	}
	
	
}
