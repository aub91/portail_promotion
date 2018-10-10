package fr.afcepf.al32.groupe2.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

//@Entity
//@Table(name="publish")
public class Publish {
	
	@Column(name="publish_date")
	private Date publishDate;
	@Column(name="cancel_publish_date")
	private Date cancelPublishDate;
	
	
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
	
	
}
