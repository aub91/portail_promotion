package fr.afcepf.al32.groupe2.test;
import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import fr.afcepf.al32.groupe2.dao.IRechercheProduits;
import fr.afcepf.al32.groupe2.dao.RechercheProduitsJpa;
import fr.afcepf.al32.groupe2.entity.BaseProduct;
import fr.afcepf.al32.groupe2.entity.Product;
import fr.afcepf.al32.groupe2.entity.Promotion;
import fr.afcepf.al32.groupe2.test.config.TestConfig;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=TestConfig.class)
@AutoConfigureTestDatabase
public class PromotionProductDaoTest {
	
	BaseProduct produit;
	Promotion promodujour;
	List<BaseProduct> baseProducts;
	
	@Autowired
	IRechercheProduits rechercheproduitjpa;
	
	@Test
	public void testerLaRechercheProduit() {
		produit=rechercheproduitjpa.findOne(1L);
	}
	
	@Test
	public void testerLaListeAll() {
		baseProducts = rechercheproduitjpa.findAll();
		
	}
	
	@Test
	@Ignore
	public void testersave() {
		rechercheproduitjpa.save(produit);
	}
	
	@Test
	@Ignore
	public void testerdelete() {
		rechercheproduitjpa.delete(1L);
	}
}
