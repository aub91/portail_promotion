package fr.afcepf.al32.groupe2.test.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fr.afcepf.al32.groupe2.entity.Promotion;
import fr.afcepf.al32.groupe2.service.ICatalogService;
import fr.afcepf.al32.groupe2.test.config.TestConfig;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=TestConfig.class)
@AutoConfigureTestDatabase
public class CatalogServiceTest {

	@Autowired
	private ICatalogService catalogService;
	
	@Test
	public void getAllDisplayableProductTest() {
		List<Promotion> result = catalogService.getAllDisplayablePromotion();
		
		Assert.assertNotNull(result);
		Assert.assertEquals(10, result.size());
	}

}
