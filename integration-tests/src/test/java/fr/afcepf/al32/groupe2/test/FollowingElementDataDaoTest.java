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
import fr.afcepf.al32.groupe2.entity.FollowingElementData;
import fr.afcepf.al32.groupe2.test.config.TestConfig;
import fr.afcepf.al32.groupe2.util.FollowableElementType;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=TestConfig.class)
@AutoConfigureTestDatabase
public class FollowingElementDataDaoTest {
	@Autowired
	private FollowingElementDataDao dao;
	
	@Test
	public void getAllByUserTest() {
		
		List<FollowingElementData> res = dao.getAllByUser(1L);
		
		Assert.assertEquals(2, res.size());

	}
	
	@Test
	public void getAllByUserAndElementTypeTest() {
		
		List<FollowingElementData> res = dao.getAllByUserAndElementType(1L, FollowableElementType.SHOP);
		
		Assert.assertEquals(1, res.size());
		Assert.assertEquals(FollowableElementType.SHOP, res.get(0).getElementType());
	}
}
