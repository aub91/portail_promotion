package fr.afcepf.al32.groupe2.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fr.afcepf.al32.groupe2.dao.ICategoryProductDao;
import fr.afcepf.al32.groupe2.entity.CategoryProduct;
import fr.afcepf.al32.groupe2.test.config.TestConfig;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=TestConfig.class)
@AutoConfigureTestDatabase
public class CategoryProductDaoTest {

	@Autowired
	private  ICategoryProductDao dao;
	@Test
	public void findOneTest() {
		CategoryProduct su=dao.findOne(1L);
		Assert.assertNotNull(su);
	}
	
	@Test
	public void findAllRootCategories() {
		List<CategoryProduct> categories = dao.findAllRootCategories();
		
		Assert.assertNotNull(categories);
		
		Assert.assertEquals(26, categories.size());
	}
	
	@Test
	@Ignore
	public void findAllRootCategoriesWithDaughter() {
		List<CategoryProduct> categories = dao.findAllRootCategoriesWithDaughters();
		
		Assert.assertNotNull(categories);
		
		Assert.assertEquals(26, categories.size());
		
		Assert.assertNotNull(categories.get(0).getCategoryDaughter());
		
	}
	
	
}
