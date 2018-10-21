package fr.afcepf.al32.groupe2.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fr.afcepf.al32.groupe2.entity.Product;
import fr.afcepf.al32.groupe2.entity.Promotion;
import fr.afcepf.al32.groupe2.service.IServicePromotion;
import fr.afcepf.al32.groupe2.test.config.TestConfig;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=TestConfig.class)
@AutoConfigureTestDatabase
public class ServicePromotionProductTest {
	@Autowired
	private IServicePromotion servicepromotion;
	
	@Test
	public void recherchepromotionparreference() {
	Promotion pr1 = servicepromotion.recherchePromotionParIdentifiant(2L);
	Assert.assertFalse(!(pr1==null));
	}

	@Test
	public void testerAjouterPromotion() {
//		Promotion pr2 = new Promotion();
//		Product pr1 = new Product();
//		pr2.setName("testname1");
//		pr2.setDescription("testdescription1");
//		pr2.setIsCumulative(false);
//		pr2.setProduct();
//		servicepromotion.AjouterPromotion(pr2);
//		Assert.assertEquals(1, 1, 0);
	}
}
