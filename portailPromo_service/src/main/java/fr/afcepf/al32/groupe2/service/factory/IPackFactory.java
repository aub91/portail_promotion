package fr.afcepf.al32.groupe2.service.factory;

import fr.afcepf.al32.groupe2.entity.Pack;

public interface IPackFactory extends IPromotionTypeFactory<Pack> {
	
	IPackFactory setNumberPurchased(Integer numberPurchased);
	IPackFactory setNumberOffered(Integer numberOffered);

}
