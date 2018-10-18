package fr.afcepf.al32.groupe2.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="reservationProduct")
public class ReservationProduct {
	@Id
	@Column(name="id_reservation")
	private Long idReservation;
	@Column(name="quantite_commandee")
	private Double quantiteCommandee;
	@Column(name="quantite_retiree")
	private Double quantiteRetiree;
	@Column(name="date_retrait")
	private Date dateRetrait;
	@OneToOne(cascade= {CascadeType.PERSIST})
	@PrimaryKeyJoinColumn
	@NotNull
	private Reservation reservation;
	public Long getIdReservation() {
		return idReservation;
	}
	public void setIdReservation(Long idReservation) {
		this.idReservation = idReservation;
	}
	public Double getQuantiteCommandee() {
		return quantiteCommandee;
	}
	public void setQuantiteCommandee(Double quantiteCommandee) {
		this.quantiteCommandee = quantiteCommandee;
	}
	public Double getQuantiteRetiree() {
		return quantiteRetiree;
	}
	public void setQuantiteRetiree(Double quantiteRetiree) {
		this.quantiteRetiree = quantiteRetiree;
	}
	public Date getDateRetrait() {
		return dateRetrait;
	}
	public void setDateRetrait(Date dateRetrait) {
		this.dateRetrait = dateRetrait;
	}
	public Reservation getReservation() {
		return reservation;
	}
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	
	
}
