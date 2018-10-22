package fr.afcepf.al32.groupe2.entity;

import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue(value="shopkeeper")
public class Shopkeeper extends User{
	
	@OneToMany(mappedBy="owner", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@MapKey(name="id")
	private Map<Long, Shop> shops;
	
	@OneToMany(mappedBy="owner", cascade=CascadeType.ALL)
	@MapKey(name="id")
	private Map<Long, TemplatePromotion> templatesPromotion;

	public Map<Long, Shop> getShops() {
		return shops;
	}

	public void setShops(Map<Long, Shop> shops) {
		this.shops = shops;
	}

	public Map<Long, TemplatePromotion> getTemplatesPromotion() {
		return templatesPromotion;
	}

	public void setTemplatesPromotion(Map<Long, TemplatePromotion> templatesPromotion) {
		this.templatesPromotion = templatesPromotion;
	}
	
	
}
