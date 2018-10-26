package fr.afcepf.al32.groupe2.entity;

import java.util.Date;

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

@Entity
@Table(name="publish")
public class Publish {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idPromotion;
	
	@Column(name="publish_date")
	private Date publishDate;
	@Column(name="cancel_publish_date")
	private Date cancelPublishDate;
	
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="promotion_id")
	private Promotion promotion;
	
	@ManyToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="reason_cancel_publish_promo_id")
	private ReasonCancelPublishPromotion reasonCancelPublishPromotion;
	
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	public Date getCancelPublishDate() {
		return cancelPublishDate;
	}
	public void setCancelPublishDate(Date cancelPublishDate) {
		this.cancelPublishDate = cancelPublishDate;
	}
	public Promotion getPromotion() {
		return promotion;
	}
	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
		promotion.setPublish(this);
	}
	public ReasonCancelPublishPromotion getReasonCancelPublishPromotion() {
		return reasonCancelPublishPromotion;
	}
	public void setReasonCancelPublishPromotion(ReasonCancelPublishPromotion reasonCancelPublishPromotion) {
		this.reasonCancelPublishPromotion = reasonCancelPublishPromotion;
	}
	
}
