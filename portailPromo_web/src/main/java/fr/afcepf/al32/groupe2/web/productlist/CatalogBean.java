package fr.afcepf.al32.groupe2.web.productlist;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ComponentSystemEvent;

import org.springframework.beans.factory.annotation.Autowired;

import fr.afcepf.al32.groupe2.entity.BaseProduct;
import fr.afcepf.al32.groupe2.service.ICatalogService;

@ManagedBean
@SessionScoped
public class CatalogBean {
	
	@Autowired
	private ICatalogService catalogService;

	private List<Long> products = new ArrayList<>(); 
	public CatalogBean() {
		
	}
	
	@PostConstruct
	public void initCatalogProduits() {
		
		products.add(2L);
		
	}
	 
	public ICatalogService getCatalogService() {
		return catalogService;
	}

	public void setCatalogService(ICatalogService catalogService) {
		this.catalogService = catalogService;
	}

	public List<Long> getProducts() {
		return products;
	}

	public void setProducts(List<Long> products) {
		this.products = products;
	}

	

}
