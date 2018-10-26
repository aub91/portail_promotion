package fr.afcepf.al32.groupe2.dao;

import fr.afcepf.al32.groupe2.entity.ReferenceProduct;


public interface IReferenceProductDao {
	
	ReferenceProduct findOne(Long idreferenceproduct);
	ReferenceProduct createOne(ReferenceProduct referenceproduct);

}
