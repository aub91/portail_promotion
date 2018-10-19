package fr.afcepf.al32.groupe2.test;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fr.afcepf.al32.groupe2.dao.ISalesUnitDao;
import fr.afcepf.al32.groupe2.entity.SalesUnit;
import fr.afcepf.al32.groupe2.service.IserviceSalesUnit;
import fr.afcepf.al32.groupe2.test.config.TestConfig;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=TestConfig.class)
@AutoConfigureTestDatabase
public class ServiceSalesUnitTest {
	
	@Autowired
	private IserviceSalesUnit servicesalesUnit;


@Test
public void rechercheUniteDeVenteParIdentifiantTest () {

	SalesUnit su2=servicesalesUnit.rechercheUniteDeVenteParIdentifiant(1L);
	Assert.assertNotNull(su2);
 
}
@Test
@Transactional
public void AjouterSalesUnittest() {
	SalesUnit suc=new SalesUnit();
	suc.setName("kilo");
	servicesalesUnit.ajouterSalesUnit(suc);
	List<SalesUnit> result = servicesalesUnit.findAll();
	Assert.assertEquals(6, result.size());

}
}
