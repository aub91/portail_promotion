package fr.afcepf.al32.groupe2.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fr.afcepf.al32.groupe2.entity.CategoryProduct;
import fr.afcepf.al32.groupe2.service.IServiceCategoryProduct;
import fr.afcepf.al32.groupe2.test.config.TestConfig;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfig.class)
@AutoConfigureTestDatabase
public class ServiceCategoryProductTest {

	@Autowired
	private IServiceCategoryProduct servicecategoryproduct;

	@Test
	public void rechercheCategoryProduitParIdentifiantTest() {
		CategoryProduct su = servicecategoryproduct.rechercheCategoryProduitParIdentifiant(1L);
		Assert.assertNotNull(su);
	}

}
