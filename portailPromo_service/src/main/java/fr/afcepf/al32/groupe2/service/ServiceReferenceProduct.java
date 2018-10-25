package fr.afcepf.al32.groupe2.service;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.afcepf.al32.groupe2.dao.IReferenceProductDao;
import fr.afcepf.al32.groupe2.entity.ReferenceProduct;

@Transactional
@Component
public class ServiceReferenceProduct implements IServiceReferenceProduct {
	@Autowired
	private IReferenceProductDao referenceproductDao;
	@Override
	public ReferenceProduct rechercheReferenceProduitParIdentifiant(Long id) {

		return referenceproductDao.findOne(id);
	
	}

	@Override
	public ReferenceProduct ajouterReferenceProduit(ReferenceProduct referenceproduct) {
		referenceproductDao.createOne(referenceproduct);
	
		
		return referenceproduct;
		
	}
	

}
