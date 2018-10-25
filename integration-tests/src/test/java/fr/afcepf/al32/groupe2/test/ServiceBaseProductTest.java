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

import fr.afcepf.al32.groupe2.dao.IReferenceProductDao;
import fr.afcepf.al32.groupe2.entity.BaseProduct;
import fr.afcepf.al32.groupe2.entity.ReferenceProduct;
import fr.afcepf.al32.groupe2.service.IServiceBaseProduct;
import fr.afcepf.al32.groupe2.test.config.TestConfig;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=TestConfig.class)
@AutoConfigureTestDatabase
public class ServiceBaseProductTest {
	@Autowired
	private IServiceBaseProduct servicebaseproduct;
	@Autowired
	private  IReferenceProductDao servicereferenceproduit;
	
	@Test
	public void rechercheReferenceProductParIdentifiantTest () {

			BaseProduct su2= servicebaseproduct.rechercheBaseProductParIdentifiant(1L);
			Assert.assertNotNull(su2);
			
		
	}
	

	@Test
	@Transactional
	public void ajouterBaseProductTest() {
		BaseProduct su0=new BaseProduct();
		ReferenceProduct su1=servicereferenceproduit.findOne(11L);
		su0.setReferenceProduct(su1);
		su0.setAddDate(new Date());
		su0.setInitPrice(5.6);
		su0.setDescription("buffet");
		su0.setImage("www.buffet.fr");
		servicebaseproduct.ajouterBaseProduct(su0);
		
		List<BaseProduct> result = servicebaseproduct.findAll();
		Assert.assertEquals(16, result.size());
	}

	

}
