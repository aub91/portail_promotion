package fr.afcepf.al32.groupe2.test.service;

import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fr.afcepf.al32.groupe2.dao.UserDao;
import fr.afcepf.al32.groupe2.entity.Client;
import fr.afcepf.al32.groupe2.entity.FollowingElementData;
import fr.afcepf.al32.groupe2.service.ISubscriberService;
import fr.afcepf.al32.groupe2.test.config.TestConfig;
import fr.afcepf.al32.groupe2.util.FollowableElementType;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=TestConfig.class)
@AutoConfigureTestDatabase
public class SubscriberServiceTest {
	
	@Autowired
	private ISubscriberService subscriberService;
	
	@Autowired
	private UserDao userDao;
	
	@Test
	public void getAllFollowableElementDataTest() {
		Client client = (Client) userDao.findOneById(1L);
		
		Map<Long, FollowingElementData> res = subscriberService.getAllFollowableElementData(client);
		
		Assert.assertEquals(2, res.size());
	}
	
	@Test
	public void getAllFollowableElementDataByElementTypeTest() {
		
		Client client = (Client) userDao.findOneById(1L);
		
		Map<Long, FollowingElementData> res = subscriberService.getAllFollowableElementDataByElementType(client, FollowableElementType.SHOP);
		
		Assert.assertEquals(1, res.size());
		Assert.assertEquals(FollowableElementType.SHOP, res.get(1L).getElementType());
	}

}
