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
@Table(name="evaluation")
public class Evaluation {
	@Id
	@Column(name="id_reservation")
	private Long idReservation;
	@Column(name="date_creation")
	private Date dateCreation;
	@Column(name="note_produit")
	private Integer noteProduit;
	@Column(name="note_interaction")
	private String noteInteraction;
	@Column(name="note_globale")
	private Integer noteGlobale;
	@OneToOne(cascade= {CascadeType.PERSIST})
	@PrimaryKeyJoinColumn
	@NotNull
	private Reservation reservation;
}
