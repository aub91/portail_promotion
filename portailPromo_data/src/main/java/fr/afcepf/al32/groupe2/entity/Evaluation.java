package fr.afcepf.al32.groupe2.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="evaluation")
public class Evaluation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="date_creation")
	private Date dateCreation;
	
	@Column(name="note_product")
	private Integer noteProduit;
	
	@Column(name="note_interaction")
	private String noteInteraction;
	
	@Column(name="overall_rating")
	private Integer overallRating;
	
	@OneToOne(cascade= {CascadeType.PERSIST})
	@PrimaryKeyJoinColumn
	@NotNull
	private Reservation reservation;
	
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public Integer getNoteProduit() {
		return noteProduit;
	}
	public void setNoteProduit(Integer noteProduit) {
		this.noteProduit = noteProduit;
	}
	public String getNoteInteraction() {
		return noteInteraction;
	}
	public void setNoteInteraction(String noteInteraction) {
		this.noteInteraction = noteInteraction;
	}


	public Integer getOverallRating() {
		return overallRating;
	}
	public void setOverallRating(Integer overallRating) {
		this.overallRating = overallRating;
	}
	public Reservation getReservation() {
		return reservation;
	}
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	public Long getId() {
		return id;
	}

}
