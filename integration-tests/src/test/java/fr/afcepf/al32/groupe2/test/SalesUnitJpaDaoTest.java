package fr.afcepf.al32.groupe2.test;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.al32.groupe2.dao.ISalesUnitDao;
import fr.afcepf.al32.groupe2.entity.SalesUnit;
import fr.afcepf.al32.groupe2.test.config.TestConfig;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=TestConfig.class)
@AutoConfigureTestDatabase
public class SalesUnitJpaDaoTest {
	@Autowired
	private  ISalesUnitDao dao;
	
	@Test
	public void findOneTest() {
		SalesUnit su=dao.findOne(1L);
		Assert.assertNotNull(su);
	}
	
	@Test
	@Transactional
	@Ignore
	public void createOneTest() {
		SalesUnit su=new SalesUnit();
		su.setName("kilo");
		dao.createOne(su);
		List<SalesUnit> result = dao.findAll();
		Assert.assertEquals(6, result.size());
	}
	

}
