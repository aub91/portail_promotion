package fr.afcepf.al32.groupe2.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

//@Entity
//@Table(name="followingElementDate")
public class FollowingElementData {
	
	private IFollowableElement element;
	@Column(name="follow_start_date")
	@NotNull
	private Date followStartDate;
	@Column(name="follow_end_date")
	private Date followEndDate;
	
	public IFollowableElement getElement() {
		return element;
	}
	public void setElement(IFollowableElement element) {
		this.element = element;
	}
	public Date getFollowStartDate() {
		return followStartDate;
	}
	public void setFollowStartDate(Date followStartDate) {
		this.followStartDate = followStartDate;
	}
	public Date getFollowEndDate() {
		return followEndDate;
	}
	public void setFollowEndDate(Date followEndDate) {
		this.followEndDate = followEndDate;
	}

}
