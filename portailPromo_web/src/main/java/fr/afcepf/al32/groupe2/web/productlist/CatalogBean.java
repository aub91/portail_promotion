package fr.afcepf.al32.groupe2.web.productlist;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import fr.afcepf.al32.groupe2.entity.Promotion;
import fr.afcepf.al32.groupe2.service.ICatalogService;

@Component
@RequestScope
public class CatalogBean {
	
	@Autowired
	private ICatalogService catalogService;

	private List<Promotion> promotions = new ArrayList<>(); 
	
	public CatalogBean() {
		
	}
	
	@PostConstruct
	public void initCatalogProduits() {
		
		promotions = catalogService.getAllDisplayablePromotion();
	}
	 
	public ICatalogService getCatalogService() {
		return catalogService;
	}

	public void setCatalogService(ICatalogService catalogService) {
		this.catalogService = catalogService;
	}

	public List<Promotion> getPromotions() {
		return promotions;
	}

	public void setPromotions(List<Promotion> promotions) {
		this.promotions = promotions;
	}

	
	

}
