package fr.afcepf.al32.groupe2.service;

import fr.afcepf.al32.groupe2.entity.ReferenceProduct;

public interface IServiceReferenceProduct {

	ReferenceProduct  rechercheReferenceProduitParIdentifiant(Long id);
	ReferenceProduct ajouterReferenceProduit(ReferenceProduct referenceproduct);
}
