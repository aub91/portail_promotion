package fr.afcepf.al32.groupe2.service.factory;

import fr.afcepf.al32.groupe2.entity.PromotionType;

public interface IPromotionTypeFactory<T extends PromotionType> {
	T fabrique();
}
