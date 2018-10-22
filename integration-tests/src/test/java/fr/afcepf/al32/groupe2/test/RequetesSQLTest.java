package fr.afcepf.al32.groupe2.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fr.afcepf.al32.groupe2.entity.BaseProduct;
import fr.afcepf.al32.groupe2.dao.IRechercheProduits;
import fr.afcepf.al32.groupe2.test.config.TestConfig;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=TestConfig.class)
@AutoConfigureTestDatabase
public class RequetesSQLTest {
	
	@Autowired
	IRechercheProduits rechercheProduitDao;
	
	
	@Test
	public void rechercheProduitSurMotClesWithEmptyListTest() {
		List<String> rqdtkeys=new ArrayList<String>();

		List<BaseProduct> retourSQL=(List<BaseProduct>) rechercheProduitDao.rechercherProduitSurMotsCles(rqdtkeys);
		Assert.assertEquals(15, retourSQL.size());
	}
	
	@Test
	public void rechercheProduitSurMotClesTest() {
		List<String> rqdtkeys=new ArrayList<String>();
		rqdtkeys.add("joker");
		rqdtkeys.add("sport");
		
		List<BaseProduct> retourSQL=(List<BaseProduct>) rechercheProduitDao.rechercherProduitSurMotsCles(rqdtkeys);
		Assert.assertEquals(3, retourSQL.size());
	}
	
	@Test
	@Ignore
	public void RequetesSQLTestA2() {
			String rqtname=null;
			Date rqtDateCreation=null;
			Date rqtDateRemove=null;
			Date rqtLimitTimePromotion=null;
			Date rqtLimitTimeTakePromotion=null;
			Long rqtQuantityAvailable=0L;
			Boolean rqtIsCumulative=false;
			List<String> rqtListTags=new ArrayList<String>();
			List<BaseProduct> retourSQL=new ArrayList<BaseProduct>();

			rqtListTags.add("test1");
			rqtListTags.add("test2");
			retourSQL=(List<BaseProduct>) rechercheProduitDao.rechercherProduitAvecCriteres(
												rqtDateCreation,
												rqtDateRemove,
												rqtLimitTimePromotion,
												rqtLimitTimeTakePromotion,
												rqtQuantityAvailable,
												rqtIsCumulative,
												rqtListTags);

	}
}
