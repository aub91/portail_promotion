package fr.afcepf.al32.groupe2.web.productlist;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import fr.afcepf.al32.groupe2.entity.BaseProduct;
import fr.afcepf.al32.groupe2.service.ICatalogService;

@Component
@RequestScope
public class CatalogBean {
	
	@Autowired
	private ICatalogService catalogService;

	private List<BaseProduct> products = new ArrayList<>(); 
	
	public CatalogBean() {
		
	}
	
	@PostConstruct
	public void initCatalogProduits() {
		
		products = catalogService.getAllDisplayableProduct();
	}
	 
	public ICatalogService getCatalogService() {
		return catalogService;
	}

	public void setCatalogService(ICatalogService catalogService) {
		this.catalogService = catalogService;
	}

	public List<BaseProduct> getProducts() {
		return products;
	}

	public void setProducts(List<BaseProduct> products) {
		this.products = products;
	}
	

}
