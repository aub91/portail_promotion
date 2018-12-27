package fr.afcepf.al32.groupe2.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.afcepf.al32.groupe2.dao.ICategoryProductDao;
import fr.afcepf.al32.groupe2.dao.IReservationDao;
import fr.afcepf.al32.groupe2.entity.CategoryProduct;
import fr.afcepf.al32.groupe2.entity.Client;

@Transactional
@Component
public class ServiceCategoryProduct implements IServiceCategoryProduct {
	@Autowired
	private ICategoryProductDao categoryProductDao;
	
	@Autowired
	private IReservationDao reservationDao;
	
	public CategoryProduct rechercheCategoryProduitParIdentifiant(Long id) {
	return categoryProductDao.findOne(id);
	}

	@Override
	public List<CategoryProduct> getAllRootCategories() {
		return categoryProductDao.findAllRootCategories();
	}

	@Override
	public List<CategoryProduct> getAllRootCategoriesWithDaughters() {
		return categoryProductDao.findAllRootCategoriesWithDaughters();
	}
	@Override
	public CategoryProduct getCategoryOfLastReservation(Client client) {
	return reservationDao.getLastReservation(client).getReservationProduct()
			.getPromotion().getBaseProduct().getReferenceProduct().getCategoriesProduct();
	}
}
