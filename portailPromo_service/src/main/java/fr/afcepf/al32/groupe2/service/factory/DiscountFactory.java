package fr.afcepf.al32.groupe2.service.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.afcepf.al32.groupe2.entity.Discount;

@Component
public class DiscountFactory implements IDiscountFactory {

	@Autowired
	private static DiscountFactory discountFactory;

	private Double discountValue;
	private Double minPurchaseAmount;

	public static DiscountFactory getDiscountType() {
		if (discountFactory == null) {
			discountFactory = new DiscountFactory();
			discountFactory.initFactory();
		}
		return discountFactory;
	}

	private void initFactory() {

	}

	@Override
	public Discount fabrique() {
		Discount discount = new Discount();
		discount.setDiscountValue(discountValue);
		discount.setMinPurchaseAmount(minPurchaseAmount);
		return discount;
	}

	@Override
	public IDiscountFactory setMinPurchaseAmount(Double minPurchaseAmount) {
		this.minPurchaseAmount = minPurchaseAmount;
		return this;
	}

	@Override
	public IDiscountFactory setDiscountValue(Double discountValue) {
		this.discountValue = discountValue;
		return this;
	}

}
