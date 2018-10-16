package fr.afcepf.al32.groupe2.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fr.afcepf.al32.groupe2.dao.FollowingElementDataDao;
import fr.afcepf.al32.groupe2.dao.UserDao;
import fr.afcepf.al32.groupe2.entity.FollowingElementData;
import fr.afcepf.al32.groupe2.entity.User;
import fr.afcepf.al32.groupe2.test.config.TestConfig;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=TestConfig.class)
@AutoConfigureTestDatabase
public class FollowingElementDataDaoTest {
	@Autowired
	private FollowingElementDataDao dao;
	
	@Autowired
	private UserDao userDao;
	
	@Test
	public void getAllByUserTest() {
		
		User user=userDao.findOneById(1L);
		
		List<FollowingElementData> res = dao.getAllByUser(1L);
		
		Assert.assertEquals(0, res.size());
	}
}
