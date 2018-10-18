package fr.afcepf.al32.groupe2.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fr.afcepf.al32.groupe2.dao.IReferenceProductDao;
import fr.afcepf.al32.groupe2.entity.ReferenceProduct;
import fr.afcepf.al32.groupe2.test.config.TestConfig;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=TestConfig.class)
@AutoConfigureTestDatabase
public class ReferenceProductDaotest {
	
	
		@Autowired
		private  IReferenceProductDao dao;
		
		@Test
		public void findOneTest() {
			ReferenceProduct su=dao.findOne(1L);
			Assert.assertNotNull(su);
		}
		@Test
		public void createOneTest() {
			ReferenceProduct su=new ReferenceProduct();
			su.setName("kilo");
			dao.createOne(su);
			Assert.assertEquals(2L, su.getId(), 0.1);
		}
		
}
