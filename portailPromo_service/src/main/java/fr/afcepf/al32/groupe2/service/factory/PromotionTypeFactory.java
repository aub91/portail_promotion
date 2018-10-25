package fr.afcepf.al32.groupe2.service.factory;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.afcepf.al32.groupe2.entity.Discount;
import fr.afcepf.al32.groupe2.entity.Pack;
import fr.afcepf.al32.groupe2.entity.PercentType;
import fr.afcepf.al32.groupe2.entity.PromotionType;

@Component
public class PromotionTypeFactory {

	@Autowired
	private static PromotionTypeFactory promotionType;

	private Map<String, Class> map = new HashMap<>();

	public static PromotionTypeFactory getPromotionType() {
		if(promotionType==null) {
			promotionType = new PromotionTypeFactory();
			promotionType.initFactory();
		}
		return promotionType; 
	}

	public PromotionTypeFactory() {
		super();
	}
	
	private void initFactory(){
		
		map.put("percentType", PercentType.class);
		map.put("pack", Pack.class);
		map.put("discount", Discount.class);
	
	}
	
	public PromotionType fabrique(String action) throws InstantiationException, IllegalAccessException{

	return (PromotionType) map.get(action).newInstance();
	}
}
