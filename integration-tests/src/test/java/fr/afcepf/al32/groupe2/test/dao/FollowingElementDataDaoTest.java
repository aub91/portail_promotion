package fr.afcepf.al32.groupe2.test.dao;

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

import fr.afcepf.al32.groupe2.dao.CategoryProductDao;
import fr.afcepf.al32.groupe2.dao.FollowingElementDataDao;
import fr.afcepf.al32.groupe2.dao.UserDao;
import fr.afcepf.al32.groupe2.entity.CategoryProduct;
import fr.afcepf.al32.groupe2.entity.Client;
import fr.afcepf.al32.groupe2.entity.FollowingElementData;
import fr.afcepf.al32.groupe2.test.config.TestConfig;
import fr.afcepf.al32.groupe2.util.FollowableElementType;
import fr.afcepf.al32.groupe2.util.SubscriberType;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=TestConfig.class)
@AutoConfigureTestDatabase
public class FollowingElementDataDaoTest {
	@Autowired
	private FollowingElementDataDao dao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private CategoryProductDao categoryProductDao;
	
	@Test
	public void getAllByUserTest() {
		
		Client client = (Client) userDao.findOneById(1L);
		
		List<FollowingElementData> res = dao.getAllByUser(client);
		
		Assert.assertEquals(2, res.size());

	}
	
	@Test
	public void getAllByUserAndElementTypeTest() {
		
		Client client = (Client) userDao.findOneById(1L);
		
		List<FollowingElementData> res = dao.getAllByUserAndElementType(client, FollowableElementType.SHOP);
		
		Assert.assertEquals(1, res.size());
		Assert.assertEquals(FollowableElementType.SHOP, res.get(0).getElementType());
	}
	
	@Test
	@Transactional
	public void saveTest() {
		Client client = (Client) userDao.findOneById(1L);
		CategoryProduct category = categoryProductDao.findOne(1L);
		
		FollowingElementData fed = new FollowingElementData();
		fed.setElement(category);
		fed.setElementType(category.getType());
		fed.setSubscriber(client);
		fed.setSubscriberType(client.getType());
		fed.setFollowStartDate(new Date());
		
		FollowingElementData res = dao.save(fed);
		
		Assert.assertEquals(3L, res.getId(), 0.1);
		Assert.assertEquals(FollowableElementType.CATEGORY, fed.getElementType());
		Assert.assertEquals(SubscriberType.CLIENT, fed.getSubscriberType());
	}
}
