package fr.afcepf.al32.groupe2.service.factory;

import fr.afcepf.al32.groupe2.entity.PercentType;

public interface IPercentTypeFactory extends IPromotionTypeFactory<PercentType> {
	IPercentTypeFactory setPercentValue(Double percentValue);
	IPercentTypeFactory setMinPurchaseAmount(Double minPurchaseAmount);
}
