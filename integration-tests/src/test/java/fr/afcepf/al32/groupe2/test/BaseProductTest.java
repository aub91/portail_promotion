package fr.afcepf.al32.groupe2.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fr.afcepf.al32.groupe2.dao.IBaseProductDao;
import fr.afcepf.al32.groupe2.entity.BaseProduct;
import fr.afcepf.al32.groupe2.entity.Promotion;
import fr.afcepf.al32.groupe2.test.config.TestConfig;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=TestConfig.class)
@AutoConfigureTestDatabase
public class BaseProductTest {
	
	@Autowired
	IBaseProductDao baseProductDao;

	@Test
	public void getPromotionList() {
		BaseProduct product = baseProductDao.findOne(1L);
		
		List<Promotion> result = product.getPromotionList();
		
		Assert.assertNotNull(result);
		
		Assert.assertEquals(2, result.size());
		Assert.assertEquals(29L, result.get(0).getId(), 0.1);
	}

}
