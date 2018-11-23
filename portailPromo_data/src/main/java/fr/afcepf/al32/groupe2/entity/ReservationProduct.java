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
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "reservation_product")
public class ReservationProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "quantity_requested")
	private Double quantityRequested;

	@Column(name = "quantity_withdrawal")
	private Double quantityWithdrawal;

	@Column(name = "withdrawal_date")
	private Date withdrawalDate;

	@OneToOne(cascade = { CascadeType.PERSIST })
	@PrimaryKeyJoinColumn
	@NotNull
	private Reservation reservation;

	@ManyToOne(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	@JoinColumn(name = "promotion_id")
	private Promotion promotion;

	public Double getQuantityRequested() {
		return quantityRequested;
	}

	public void setQuantityRequested(Double quantityRequested) {
		this.quantityRequested = quantityRequested;
	}

	public Double getQuantityWithdrawal() {
		return quantityWithdrawal;
	}

	public void setQuantityWithdrawal(Double quantityWithdrawal) {
		this.quantityWithdrawal = quantityWithdrawal;
	}

	public Date getWithdrawalDate() {
		return withdrawalDate;
	}

	public void setWithdrawalDate(Date withdrawalDate) {
		this.withdrawalDate = withdrawalDate;
	}

	public Long getId() {
		return id;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public Promotion getPromotion() {
		return promotion;
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}
}
