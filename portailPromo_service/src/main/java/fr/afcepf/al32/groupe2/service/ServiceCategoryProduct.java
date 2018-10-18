package fr.afcepf.al32.groupe2.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.afcepf.al32.groupe2.dao.ICategoryProductDao;
import fr.afcepf.al32.groupe2.entity.CategoryProduct;

@Transactional
@Component
public class ServiceCategoryProduct implements IServiceCategoryProduct {
	@Autowired
	private ICategoryProductDao categoryproductdao;
	
	public CategoryProduct rechercheCategoryProduitParIdentifiant(Long id) {
		                  
		
			
			return categoryproductdao.findOne(id);
	}

}
