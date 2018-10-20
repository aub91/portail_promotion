package fr.afcepf.al32.groupe2.service.factory;

import fr.afcepf.al32.groupe2.entity.Discount;

public interface IDiscountFactory extends IPromotionTypeFactory<Discount> {
	
	IDiscountFactory setDiscountValue(Double discountValue);
	IDiscountFactory setMinPurchaseAmount(Double minPurchaseAmount);

}
