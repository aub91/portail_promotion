package fr.afcepf.al32.groupe2.test.service;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Ignore;
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
import fr.afcepf.al32.groupe2.service.IFollowableElementService;
import fr.afcepf.al32.groupe2.service.ISubscriberService;
import fr.afcepf.al32.groupe2.test.config.TestConfig;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=TestConfig.class)
@AutoConfigureTestDatabase
public class FollowableElementServiceTest {
	
	@Autowired
	private IFollowableElementService followableElementService;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ISubscriberService subscriberService;
	
	@Autowired
	private FollowingElementDataDao followingElementDataDao;
	
	@Autowired
	private CategoryProductDao categoryProductDao;
	
	@Test
	@Transactional
	public void addSubscriberTest() {
		Client client = (Client) userDao.findOneById(1L);
		CategoryProduct category = categoryProductDao.findOne(1L);
		
		FollowingElementData followData = followableElementService.addSubscriber(category, client);
		
		Map<Long, FollowingElementData> res = subscriberService.getAllFollowableElementData(client);
		
		Assert.assertEquals(3, res.size(), 0.1);
		Assert.assertEquals(category.getType(), res.get(followData.getId()).getElementType());
		
	}
	
	@Test
	@Transactional
	public void removeSubscriberTest() {
		Client client = (Client) userDao.findOneById(1L);
		
		FollowingElementData data = followingElementDataDao.getOne(1L);
		
		followableElementService.removeSubscriber(data);
		
		Map<Long, FollowingElementData> res = subscriberService.getAllFollowableElementData(client);
		
		Assert.assertEquals(1, res.size(), 0.1);
		Assert.assertNotNull(data.getFollowEndDate());
	}
	
	@Test
	@Ignore
	public void notifySubscriberTest() {
		CategoryProduct category = categoryProductDao.findOne(1L);
		
		followableElementService.notifySubscribers(category);
	}

}
