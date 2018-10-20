package fr.afcepf.al32.groupe2.service.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.afcepf.al32.groupe2.entity.PercentType;

@Component
public class PercentTypeFactory implements IPercentTypeFactory {

	@Autowired
	private static PercentTypeFactory percentTypeFactory;
	
	private Double percentValue;
	private Double minPurchaseAmount;
	
	public static PercentTypeFactory getPercentTypeType(){
		 if(percentTypeFactory == null) {
			 percentTypeFactory = new PercentTypeFactory();
			 percentTypeFactory.initFactory();
		 }
		return percentTypeFactory;
	}
	
	private void initFactory() {
		
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
