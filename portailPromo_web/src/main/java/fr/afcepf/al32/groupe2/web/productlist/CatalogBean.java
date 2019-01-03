package fr.afcepf.al32.groupe2.web.productlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import fr.afcepf.al32.groupe2.entity.CategoryProduct;
import fr.afcepf.al32.groupe2.entity.Client;
import fr.afcepf.al32.groupe2.entity.Promotion;
import fr.afcepf.al32.groupe2.entity.User;
import fr.afcepf.al32.groupe2.service.ICatalogService;
import fr.afcepf.al32.groupe2.service.IServiceCategoryProduct;
import fr.afcepf.al32.groupe2.service.IServicePromotion;
import fr.afcepf.al32.groupe2.web.connexion.ConnectionBean;
import fr.afcepf.al32.groupe2.ws.dto.CategoryProductDto;
import fr.afcepf.al32.groupe2.ws.dto.OrchestratorResearchDtoResponse;
import fr.afcepf.al32.groupe2.ws.dto.PromotionDto;
import fr.afcepf.al32.groupe2.ws.itf.IWsPromoTemplate;
import fr.afcepf.al32.groupe2.ws.itf.IWsRecherche;
import fr.afcepf.al32.groupe2.ws.wsPromoTemplate.dto.PromotionTemplateResultDto;
import fr.afcepf.al32.groupe2.ws.wsPromoTemplate.dto.TopPromotionTemplateResultDto;

@Component
@RequestScope
@Transactional
public class CatalogBean {

	@Autowired
	private ICatalogService catalogService;

	@Autowired
	private IServicePromotion servicePromotion;

	@Autowired
	private IServiceCategoryProduct serviceCategoryProduct;

	@Autowired
	private IWsRecherche rechercheDelegate;

	@Autowired
	private ConnectionBean connectionBean;

	@Autowired
	private IWsPromoTemplate promoClientService;

	private List<Promotion> promotions = new ArrayList<>();

	private List<PromotionTemplateResultDto> topPromotionsClient;

	private List<CategoryProduct> categories;

	private String selectedCategory;

	/**
	 * Attribut pour recherche par mot-clé. Suite de mots clés séparés par des
	 * espaces.
	 */
	private String searchField;

	/**
	 * Attribut pour la recherche par lieu. Adresse servant de point central.
	 */
	private String searchSourceAddress = "";

	/**
	 * Attribut pour la recherche par lieu. Périmètre de recherche en km.
	 */
	private Integer searchPerimeter = 11;

	/**
	 * Message d'avertissement si l'adresse n'existe pas.
	 */
	private String addressWarning;

	public CatalogBean() {

	}

	public List<PromotionTemplateResultDto> trouverLesPromoPreferees(Client client) {

		CategoryProduct categoryProduct = serviceCategoryProduct.getCategoryOfLastReservation(client);
		String category = null;
		if (categoryProduct != null) {
			category = categoryProduct.getName();
		}

		TopPromotionTemplateResultDto resultDto = promoClientService.searchByClientsFavoriteCategory(
				Double.parseDouble(client.getAddress().getCoordinates().getLongitude()),
				Double.parseDouble(client.getAddress().getCoordinates().getLatitude()), category);

		return resultDto.getTemplates();
	}

	public String search() {
		List<String> keyWords = Arrays.asList(searchField.split(" "));
		CategoryProduct category = categories.stream()
				.filter(categoryProduct -> categoryProduct.getName().equals(selectedCategory)).findFirst().orElse(null);
		OrchestratorResearchDtoResponse orchestratorResponse = rechercheDelegate.searchListPromotion(
				searchSourceAddress, searchPerimeter, keyWords,
				category == null ? null : new CategoryProductDto(category.getId()));

		if (!orchestratorResponse.getPromotions().isEmpty()) {
			promotions = servicePromotion.findAllValidByIds(orchestratorResponse.getPromotions().stream()
					.map(PromotionDto::getId).collect(Collectors.toList()));
		} else {
			promotions = Collections.emptyList();
		}

		if (!orchestratorResponse.getAddressValid()) {
			addressWarning = "Adresse non trouvée";
		} else {
			addressWarning = "";
		}
		return "index";
	}

	public String searchByCategory(CategoryProduct category) { 
		if (category != null) {
			promotions = catalogService.searchByCategory(category);
		}
		return "index";
	}

	@PostConstruct
	public void initCatalogProduits() {

		promotions = getAllPromotions();

		categories = getAllRootCategories().stream().sorted(Comparator.comparing(CategoryProduct::getName))
				.collect(Collectors.toList());
		
		User user =  connectionBean.getLoggedUser();
		if (user != null && user.getClass().equals(Client.class)) {
			topPromotionsClient= trouverLesPromoPreferees((Client) user);
		}

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

	public List<Promotion> getAllPromotions() {
		return catalogService.getAllDisplayablePromotion();
	}

	public List<CategoryProduct> getAllRootCategories() {
		return catalogService.getAllRootCategories();
	}

	public List<CategoryProduct> getCategories() {
		return categories;
	}

	public String getSelectedCategory() {
		return selectedCategory;
	}

	public void setSelectedCategory(String selectedCategory) {
		this.selectedCategory = selectedCategory;
	}

	public String getSearchField() {
		return searchField;
	}

	public void setSearchField(String searchField) {
		this.searchField = searchField;
	}

	public String getSearchSourceAddress() {
		return searchSourceAddress;
	}

	public void setSearchSourceAddress(String searchSourceAddress) {
		this.searchSourceAddress = searchSourceAddress;
	}

	public Integer getSearchPerimeter() {
		return searchPerimeter;
	}

	public void setSearchPerimeter(Integer searchPerimeter) {
		this.searchPerimeter = searchPerimeter;
	}

	public String getAddressWarning() {
		return addressWarning;
	}

	public void setAddressWarning(String addressWarning) {
		this.addressWarning = addressWarning;
	}

	public IServicePromotion getServicePromotion() {
		return servicePromotion;
	}

	public void setServicePromotion(IServicePromotion servicePromotion) {
		this.servicePromotion = servicePromotion;
	}

	public IServiceCategoryProduct getServiceCategoryProduct() {
		return serviceCategoryProduct;
	}

	public void setServiceCategoryProduct(IServiceCategoryProduct serviceCategoryProduct) {
		this.serviceCategoryProduct = serviceCategoryProduct;
	}

	public IWsRecherche getRechercheDelegate() {
		return rechercheDelegate;
	}

	public void setRechercheDelegate(IWsRecherche rechercheDelegate) {
		this.rechercheDelegate = rechercheDelegate;
	}

	public ConnectionBean getConnectionBean() {
		return connectionBean;
	}

	public void setConnectionBean(ConnectionBean connectionBean) {
		this.connectionBean = connectionBean;
	}

	public IWsPromoTemplate getPromoClientService() {
		return promoClientService;
	}

	public void setPromoClientService(IWsPromoTemplate promoClientService) {
		this.promoClientService = promoClientService;
	}

	public void setCategories(List<CategoryProduct> categories) {
		this.categories = categories;
	}

	public List<PromotionTemplateResultDto> getTopPromotionsClient() {
		return topPromotionsClient;
	}

	public void setTopPromotionsClient(List<PromotionTemplateResultDto> topPromotionsClient) {
		this.topPromotionsClient = topPromotionsClient;
	}

}