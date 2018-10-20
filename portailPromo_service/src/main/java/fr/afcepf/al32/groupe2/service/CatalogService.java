package fr.afcepf.al32.groupe2.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.afcepf.al32.groupe2.entity.BaseProduct;

@Component
@Transactional
public class CatalogService implements ICatalogService {


	@Autowired
	IServiceBaseProduct productService;
	
	@Override
	public List<BaseProduct> getAllDisplayableProduct() {
		List<BaseProduct> list = productService.findAllValid();
		return list.stream().filter(product -> product.getPromotionList().size() != 0).collect(Collectors.toList());
	}
}
