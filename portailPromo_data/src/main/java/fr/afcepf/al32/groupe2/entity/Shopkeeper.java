package fr.afcepf.al32.groupe2.entity;

import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue(value="shopkeeper")
public class Shopkeeper extends User{
	
	@OneToMany(mappedBy="owner", cascade=CascadeType.ALL)
	@MapKey(name="id")
	private Map<Long, Shop> shops;
}
