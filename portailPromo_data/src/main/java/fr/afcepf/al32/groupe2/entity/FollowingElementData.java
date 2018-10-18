
package fr.afcepf.al32.groupe2.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Any;
import org.hibernate.annotations.AnyMetaDef;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.MetaValue;

import fr.afcepf.al32.groupe2.util.FollowableElementType;
import fr.afcepf.al32.groupe2.util.SubscriberType;

@AnyMetaDef(
		name="followableElementMetaDef",
		idType = "long",
	    metaType = "string",
	    metaValues = {
	    	@MetaValue( value = FollowableElementType.CATEGORY, targetEntity = CategoryProduct.class),
	    	@MetaValue( value = FollowableElementType.PRODUCT, targetEntity = BaseProduct.class),
	    	@MetaValue( value = FollowableElementType.REFERENCE, targetEntity = ReferenceProduct.class),
	    	@MetaValue( value = FollowableElementType.SHOP, targetEntity = Shop.class)
	    	})
@AnyMetaDef(
		name="subscriberMetaDef",
		idType = "long",
	    metaType = "string",
	    metaValues = {
	    	@MetaValue( value = SubscriberType.CLIENT, targetEntity = Client.class)
	    	})
@NamedQueries(value= {
		@NamedQuery(name="FollowingElementData.getAllCurrentByUser", 
				query="SELECT fed FROM FollowingElementData fed WHERE fed.subscriberType = 'CLIENT' AND fed.subscriber.id = :userId AND fed.followEndDate = null"),
		@NamedQuery(name="FollowingElementData.getAllCurrentByUserAndElementType", 
				query="SELECT fed FROM FollowingElementData fed WHERE fed.subscriberType = 'CLIENT' AND fed.subscriber.id = :userId AND fed.elementType = :type AND fed.followEndDate = null")
})
@Entity
@Table(name="following_element_data")
public class FollowingElementData {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="element_type", insertable=false, updatable=false)
	private String elementType;
	
	@JoinColumn(name="element_id")
	@Any(metaDef="followableElementMetaDef", metaColumn = @Column( name = "element_type" ), fetch=FetchType.LAZY)
	@Cascade(value=org.hibernate.annotations.CascadeType.MERGE)
	private IFollowableElement element;
	
	@Column(name="subscriber_type", insertable=false, updatable=false)
	private String subscriberType;
	
	@JoinColumn(name="subscriber_id")
	@Any(metaDef="subscriberMetaDef", metaColumn = @Column( name = "subscriber_type" ), fetch=FetchType.LAZY)
	@Cascade(value=org.hibernate.annotations.CascadeType.MERGE)
	private ISubscriber subscriber;
	
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
	public String getElementType() {
		return elementType;
	}
	public void setElementType(String elementType) {
		this.elementType = elementType;
	}
	public String getSubscriberType() {
		return subscriberType;
	}
	public void setSubscriberType(String subscriberType) {
		this.subscriberType = subscriberType;
	}
	public ISubscriber getSubscriber() {
		return subscriber;
	}
	public void setSubscriber(ISubscriber subscriber) {
		this.subscriber = subscriber;
	}
	public Long getId() {
		return id;
	}
}
