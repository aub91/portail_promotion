package fr.afcepf.al32.groupe2.test.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fr.afcepf.al32.groupe2.dao.ClientDao;
import fr.afcepf.al32.groupe2.dao.ICategoryProductDao;
import fr.afcepf.al32.groupe2.entity.CategoryProduct;
import fr.afcepf.al32.groupe2.entity.Client;
import fr.afcepf.al32.groupe2.test.config.TestConfig;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=TestConfig.class)
@AutoConfigureTestDatabase
public class ClientDaoTest {
	
	@Autowired
	private ClientDao clientDao;
	
	@Autowired
	private ICategoryProductDao categoryProductDao;
	
	@Test
	public void findAllFollowingFollowableElementTest() {
		CategoryProduct element = categoryProductDao.findOne(1L);
		List<Client> res = clientDao.findAllFollowingFollowableElement(element);
		
		Assert.assertEquals(1, res.size(), 0.1);
		Assert.assertEquals(1L, res.get(0).getId(), 0.1);
	}

}
