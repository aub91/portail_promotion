package fr.afcepf.al32.groupe2.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fr.afcepf.al32.groupe2.dao.IPromotionDao;
import fr.afcepf.al32.groupe2.entity.Promotion;
import fr.afcepf.al32.groupe2.test.config.TestConfig;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=TestConfig.class)
@AutoConfigureTestDatabase
public class PromotionTest {

	@Autowired
	private IPromotionDao promotionDao;
	
	@Test
	public void getPriceAfterPromotionTest() {
		Promotion promotionPercentage = promotionDao.findOne(29L);
		
		Double resultPercentage = promotionPercentage.getPriceAfterPromotion();
		
		Assert.assertEquals(19.0, resultPercentage, 0.1);
		
		Promotion promotionValue = promotionDao.findOne(18L);
		
		Double resultValue = promotionValue.getPriceAfterPromotion();
		
		Assert.assertEquals(25.0, resultValue, 0.1);
		
		Promotion promotionPack = promotionDao.findOne(16L);
		
		Double resultPack = promotionPack.getPriceAfterPromotion();
		
		Assert.assertEquals(16.67, resultPack, 0.01);
	}

}
