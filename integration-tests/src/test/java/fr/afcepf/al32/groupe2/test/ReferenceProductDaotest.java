package fr.afcepf.al32.groupe2.test;

import java.util.Date;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fr.afcepf.al32.groupe2.dao.ICategoryProductDao;
import fr.afcepf.al32.groupe2.dao.IReferenceProductDao;
import fr.afcepf.al32.groupe2.dao.ISalesUnitDao;
import fr.afcepf.al32.groupe2.entity.CategoryProduct;
import fr.afcepf.al32.groupe2.entity.ReferenceProduct;
import fr.afcepf.al32.groupe2.entity.SalesUnit;
import fr.afcepf.al32.groupe2.test.config.TestConfig;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=TestConfig.class)
@AutoConfigureTestDatabase
public class ReferenceProductDaotest {
	
	
		@Autowired
		private  IReferenceProductDao dao1;
		@Autowired
		private  ICategoryProductDao dao2;
		@Autowired
		private  ISalesUnitDao dao3;
		@Test
		public void findOneTest() {
			ReferenceProduct su=dao1.findOne(1L);
			Assert.assertNotNull(su);
		}
		@Test
		@Transactional
		public void createOneTest() {
			ReferenceProduct su0=new ReferenceProduct();
			
			CategoryProduct su1=dao2.findOne(1L);
	
			SalesUnit su2=dao3.findOne(1L);
			su0.setCategoriesProduct(su1);
			su0.setSalesUnit(su2);
			su0.setName("buffet");
			su0.setDateReferencing(new Date());
			dao1.createOne(su0);
			Assert.assertEquals(15L, su0.getId(), 0.1);
		}
		
}
