package fr.afcepf.al32.groupe2.service.factory;

import fr.afcepf.al32.groupe2.entity.PercentType;

public class PercentTypeFactory implements IPercentTypeFactory {

	private static PercentTypeFactory percentTypeFactory;
	
	private Double percentValue;
	private Double minPurchaseAmount;
	
	public static PercentTypeFactory getPercentTypeType(){
		 if(percentTypeFactory == null) {
			 percentTypeFactory = new PercentTypeFactory();
		 }
		return percentTypeFactory;
	}

	@Override
	public PercentType fabrique() {
		PercentType percentType = new PercentType();
		percentType.setMinPurchaseAmount(minPurchaseAmount);
		percentType.setPercentValue(percentValue);
		return percentType;
	}

	@Override
	public IPercentTypeFactory setPercentValue(Double percentValue) {
		this.percentValue = percentValue;
		return this;
	}

	@Override
	public IPercentTypeFactory setMinPurchaseAmount(Double minPurchaseAmount) {
		this.minPurchaseAmount = minPurchaseAmount;
		return this;
	}

}
