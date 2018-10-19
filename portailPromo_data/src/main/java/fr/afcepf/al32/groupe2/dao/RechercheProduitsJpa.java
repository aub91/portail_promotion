package fr.afcepf.al32.groupe2.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import fr.afcepf.al32.groupe2.entity.BaseProduct;
import fr.afcepf.al32.groupe2.entity.Product;

@Component
@Transactional //idealement en version Spring
public class RechercheProduitsJpa implements IRechercheProduits {

	@PersistenceContext
	private EntityManager entityManager;
	
	private String baseRequest = "SELECT base_product.id, base_product.init_price,"
			+ " base_product.description,"
			+ " base_product.add_date,"
			+ " base_product.remove_date"
			+ " FROM base_product INNER JOIN reference_product "
			+ "ON base_product.reference_product_id= reference_product.id "
			+ "WHERE base_product.remove_date IS NULL";
	
	@Override
	public BaseProduct findOne(Long id_product) {
		return entityManager.find(BaseProduct.class, id_product);
	}
	
	@Override
	public void save(BaseProduct product) {
		if(product.getId()==null)
			entityManager.persist(product);//INSERT INTO ...
		else 
			entityManager.merge(product); //UPDATE SQL
	}
	
	@Override
	public void delete(Long id_product) {
		Product c = entityManager.find(Product.class, id_product);
		entityManager.remove(c);
	}
	
	@Override
	public List<BaseProduct> findAll(){
		return entityManager.createNamedQuery("BaseProduct.findAll", BaseProduct.class)
	            .getResultList();
	}
	
	@Override
	public List<BaseProduct> rechercherProduitAvecReferenceId(Long id_product) {
		return entityManager.createNamedQuery("Product.id", BaseProduct.class)
				.setParameter("id", id_product)
	            .getResultList();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<BaseProduct> rechercherProduitSurMotsCles( List<String> rqdkeys)
	{
			String rqdFinale=baseRequest;
			if(!(rqdkeys.size()==0)){
				rqdFinale+=" AND ((upper(base_product.description) LIKE"+ " '%"+rqdkeys.get(0).toUpperCase()+"%')"
						+" OR (upper(reference_product.name) LIKE"+ " '%"+rqdkeys.get(0).toUpperCase()+"%')";
				for(int k=0;k<rqdkeys.size();k++ )
					rqdFinale+=" OR (upper(base_product.description) LIKE"+ " '%"+rqdkeys.get(k).toUpperCase()+"%')"
								+" OR (upper(reference_product.name) LIKE"+ " '%"+rqdkeys.get(k).toUpperCase()+"%')";
				rqdFinale+=");";
			} else {
				rqdFinale+=";";
			}
			return ((List<BaseProduct>) entityManager.createNativeQuery(rqdFinale).getResultList());
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<BaseProduct> rechercherProduitAvecCriteres(
														Date rqDateCreation,
														Date rqDateRemove,
														Date rqLimitTimePromotion,
														Date rqLimitTimeTakePromotion,
														Long rqQuantityAvailable,
														Boolean rqIsCumulative,
														List<String> rqListTags) {
		String rqFinale=baseRequest;
		List<String> rqwhere = new ArrayList<String>();
		entityManager.clear(); //cleard'éventuelles contextes persistants
		if(!(rqDateCreation==null))
			rqwhere.add("(base_product.dateCreation LIKE"+" %"+rqDateCreation+"% "+")");
		if(!(rqDateRemove==null))
			rqwhere.add("(ProductWithPromotion.dateRemove LIKE"+" %"+rqDateRemove+"% "+")");
		if(!(rqLimitTimePromotion==null))
			rqwhere.add("(ProductWithPromotion.rqLimitTimePromotion==$rqLimitTimePromotion)");
		if(!(rqLimitTimePromotion==null))
			rqwhere.add("(ProductWithPromotion.rqLimitTimeTakPromotion==$rqLimitTimeTak)");
		if(!(rqQuantityAvailable==0))
			rqwhere.add("(ProductWithPromotion.rqQuantityAvailable==$rqQuantityAvailable)");
		if(!(rqIsCumulative==null))
			rqwhere.add("(ProductWithPromotion.rqIsCumulative==$rqIsCumulative)");
		// traitement des tags dans une liste de tags (table dans la base.
		// TODO traitement des tags dans une liste de tags (table dans la base).
//		if(!(rqListTags==null))
//		{
//			rqwhere.add("? IN Product.name OR ? IN Product.description");
//			// teste si cette option est la première ou s'il faut rajouter le lien " AND " avant
////			if(rqname.indexOf("WHERE")>-1)	rqname=rqname+" AND "; else rqname=rqname+" WHERE (";
//			rqFinale=rqFinale+"(INNERJOIN)";
//			rqwhere.add("(INNERJOIN)");
//			rqFinale=rqFinale+");";
//		}
		// teste si un filtrage est demandé ou non pour terminer la requete par ); ou ;.

		if(rqwhere.isEmpty()) rqFinale=rqFinale+";";
		else {
			rqFinale=rqFinale+" WHERE ("+rqwhere.get(0);
			int i;
			for(i=1; i<rqwhere.size(); i++)
			{
				rqFinale+=" AND "+rqwhere.get(i);
			}
		}
		return (List<BaseProduct>) (entityManager.createNativeQuery(rqFinale).getResultList());
	}
}
