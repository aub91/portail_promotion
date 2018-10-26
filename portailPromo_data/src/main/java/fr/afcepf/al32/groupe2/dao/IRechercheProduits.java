package fr.afcepf.al32.groupe2.dao;

import java.util.Date;
import java.util.List;

import fr.afcepf.al32.groupe2.entity.BaseProduct;

public interface IRechercheProduits extends IGenericDao<BaseProduct> {
		public List<BaseProduct> rechercherProduitAvecReferenceId(Long idProduct);
		public List<BaseProduct> rechercherProduitAvecCriteres(
															Date rqDateCreation,
															Date rqDateRemove,
															Date rqLimitTimePromotion,
															Date rqLimitTimeTakePromotion,
															Long rqQuantityAvailable,
															Boolean rqIsCumulative,
															List<String> rqListTags);
		public List<BaseProduct> rechercherProduitSurMotsCles(List<String> keyWords);
}
