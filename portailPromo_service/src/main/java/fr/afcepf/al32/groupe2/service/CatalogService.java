package fr.afcepf.al32.groupe2.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.afcepf.al32.groupe2.entity.CategoryProduct;
import fr.afcepf.al32.groupe2.entity.Promotion;

@Component
@Transactional
public class CatalogService implements ICatalogService {
	@Autowired
	IServicePromotion promotionService;
	
	@Autowired
	IServiceCategoryProduct categoryService;
	
	@Override
	public List<Promotion> getAllDisplayablePromotion() {
		List<Promotion> list = promotionService.findAllValid();
		return list.stream()
				.filter(promotion -> {
			LocalDateTime publishDate = promotion.getPublish().getPublishDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
			return LocalDateTime.now().isBefore(publishDate.plus(promotion.getLimitTimePromotion()));
				})
				.collect(Collectors.toList());
	}

	@Override
	public List<CategoryProduct> getAllRootCategories() {
		return categoryService.getAllRootCategories();
	}

	@Override
	public List<Promotion> searchByCategory(CategoryProduct category) {
		List<Promotion> list = getAllDisplayablePromotion();
		return list.stream().filter(promotion -> filterOnCategoryName(category, promotion)).collect(Collectors.toList());
	}

	private boolean filterOnCategoryName(CategoryProduct category, Promotion promotion){
		String categoryName = category.getName();
		CategoryProduct promotionCategory = promotion.getBaseProduct().getReferenceProduct().getCategoriesProduct();
		return isSubCategoryOf(categoryName, promotionCategory);
	}

	private boolean isSubCategoryOf(String targetCategoryName, CategoryProduct categoryToCompare){
		if(categoryToCompare.getName().equals(targetCategoryName)){
			return true;
		} else if (categoryToCompare.getCategoryMum() != null){
			return isSubCategoryOf(targetCategoryName, categoryToCompare.getCategoryMum());
		} else {
			return false;
		}
	}
	
	
}
