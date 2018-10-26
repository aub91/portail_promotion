package fr.afcepf.al32.groupe2.service.factory;

import fr.afcepf.al32.groupe2.entity.Discount;

public class DiscountFactory implements IDiscountFactory {

	private static DiscountFactory discountFactory;

	private Double discountValue;
	private Double minPurchaseAmount;

	public static DiscountFactory getDiscountType() {
		if (discountFactory == null) {
			discountFactory = new DiscountFactory();
		}
		return discountFactory;
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
