package fr.afcepf.al32.groupe2.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.afcepf.al32.groupe2.dao.ICategoryProductDao;
import fr.afcepf.al32.groupe2.entity.CategoryProduct;

@Transactional
@Component
public class ServiceCategoryProduct implements IServiceCategoryProduct {
	@Autowired
	private ICategoryProductDao categoryProductDao;
	
	public CategoryProduct rechercheCategoryProduitParIdentifiant(Long id) {
		                  
		
			
			return categoryProductDao.findOne(id);
	}

	@Override
	public List<CategoryProduct> getAllRootCategories() {
		// TODO Auto-generated method stub
		return categoryProductDao.findAllRootCategories();
	}

	@Override
	public List<CategoryProduct> getAllRootCategoriesWithDaughters() {
		// TODO Auto-generated method stub
		return categoryProductDao.findAllRootCategoriesWithDaughters();
	}

}
