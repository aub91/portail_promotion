package fr.afcepf.al32.groupe2.test;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fr.afcepf.al32.groupe2.dao.IBaseProductDao;
import fr.afcepf.al32.groupe2.dao.IReferenceProductDao;
import fr.afcepf.al32.groupe2.entity.BaseProduct;
import fr.afcepf.al32.groupe2.entity.ReferenceProduct;
import fr.afcepf.al32.groupe2.test.config.TestConfig;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfig.class)
@AutoConfigureTestDatabase
public class BaseProductDaotest {

	@Autowired
	private IBaseProductDao dao1;
	@Autowired
	private IReferenceProductDao dao2;

//			@Autowired
//			private  IBaseProductDao dao2;
//			@Autowired
//			private  IBaseProductDao dao3;
	@Test
	public void findOneTest() {
		BaseProduct su = dao1.findOne(1L);
		Assert.assertNotNull(su);
	}

	@Test
	public void findAllTest() {
		List<BaseProduct> su = dao1.findAll();
		Assert.assertNotNull(su);
		Assert.assertEquals(15L, su.size());
	}

	@Test
	public void findAllValidTest() {
		List<BaseProduct> su = dao1.findAllValid();
		Assert.assertNotNull(su);
		Assert.assertEquals(15L, su.size());
	}

	@Test
	@Transactional
	public void createOneTest() {
		BaseProduct su0 = new BaseProduct();
		// BaseProduct su1=new BaseProduct();
		// BaseProduct su2= new BaseProduct();
		ReferenceProduct su1 = dao2.findOne(11L);

		su0.setReferenceProduct(su1);
		su0.setAddDate(new Date());
		su0.setInitPrice(5.6);
		su0.setDescription("jeans");
		su0.setImage("www.jeans.fr");
		dao1.createOne(su0);
		// 14 +14
		// Assert.assertEquals(29L, su0.getId(), 0.1);
		List<BaseProduct> su2 = dao1.findAll();
		Assert.assertEquals(16L, su2.size(), 0.1);
	}

//INSERT INTO sales_unit(id,name)VALUES(1,'Unité')
//INSERT INTO sales_unit(id,name)VALUES(2,'Gr')
//INSERT INTO sales_unit(id,name)VALUES(3,'Kg')
//INSERT INTO sales_unit(id,name)VALUES(4,'Cl')
//INSERT INTO sales_unit(id,name)VALUES(5,'L')	
//			INSERT INTO reference_product(id,name, date_referencing,date_derefencing,unite_de_vente,categorie_Produit) 
//			VALUES(1,'Jeans',SYSDATE(),null,1,218)
//			VALUES(2,'Chaussettes',SYSDATE(),null,1,219)
//			VALUES(3,'Pyjamas',SYSDATE(),null,1,220)
//			VALUES(4,'T-shirt sports',SYSDATE(),null,1,221)
//			VALUES(5,'Maillots de bain',SYSDATE(),null,1,222)
//			VALUES(6,' Polos',SYSDATE(),null,1,223)
//			VALUES(7,'Chemises',SYSDATE(),null,1,224)
//			VALUES(8,'Pulls',SYSDATE(),null,1,225)
//			VALUES(9,'Vestes',SYSDATE(),null,1,226)
//			VALUES(10,'Manteaux',SYSDATE(),null,1,227)
//			VALUES(11,'Pantalons',SYSDATE(),null,1,228)
//			VALUES(12,'Cravates',SYSDATE(),null,1,229)
//			VALUES(13,'caleçon',SYSDATE(),null,1,230)
//			VALUES(14,'Bandeau de sport',SYSDATE(),null,1,231)
}
