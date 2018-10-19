package fr.afcepf.al32.groupe2.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.afcepf.al32.groupe2.dao.IBaseProductDao;
import fr.afcepf.al32.groupe2.entity.BaseProduct;

@Transactional
@Component
public class ServiceBaseProduct implements IServiceBaseProduct {
	
	@Autowired
	private IBaseProductDao baseproductdao;
	
	@Override
	public BaseProduct rechercheBaseProductParIdentifiant(Long idUnite) {
		
		return baseproductdao.findOne(idUnite);
	}

	@Override
	public BaseProduct AjouterBaseProduct(BaseProduct baseProduct) {
		baseproductdao.createOne(baseProduct);
		return baseProduct;
	}

	@Override
	public List<BaseProduct> findAll() {
		// TODO Auto-generated method stub
		return baseproductdao.findAll();
	}

	@Override
	public List<BaseProduct> findAllValid() {
		// TODO Auto-generated method stub
		return baseproductdao.findAllValid();
	}

}
