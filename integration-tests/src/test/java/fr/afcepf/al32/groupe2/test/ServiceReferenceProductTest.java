package fr.afcepf.al32.groupe2.test;



import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fr.afcepf.al32.groupe2.dao.ICategoryProductDao;
import fr.afcepf.al32.groupe2.dao.ISalesUnitDao;
import fr.afcepf.al32.groupe2.entity.CategoryProduct;
import fr.afcepf.al32.groupe2.entity.ReferenceProduct;
import fr.afcepf.al32.groupe2.entity.SalesUnit;
import fr.afcepf.al32.groupe2.service.IServiceReferenceProduct;
import fr.afcepf.al32.groupe2.test.config.TestConfig;

import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=TestConfig.class)
@AutoConfigureTestDatabase
public class ServiceReferenceProductTest {	
	@Autowired
	private IServiceReferenceProduct servicereferenceproduct;
	
	@Autowired
	private  ISalesUnitDao dao2;
	@Autowired
	private  ICategoryProductDao dao3;

@Test
public void rechercheReferenceProductParIdentifiantTest () {

	ReferenceProduct su2= servicereferenceproduct.rechercheReferenceProduitParIdentifiant(1L);
	Assert.assertNotNull(su2);
	//ReferenceProduct su3= servicereferenceproduct.rechercheReferenceProduitParIdentifiant(2L);
}
@Test
@Transactional
public void ajouterReferenceProducttest() {
	ReferenceProduct suc0=new ReferenceProduct();
	SalesUnit suc1=new SalesUnit();
	CategoryProduct suc2=new CategoryProduct();
	//INSERT INTO reference_product(id,name, date_referencing,date_derefencing,unite_de_vente,categorie_Produit) VALUES (1, 'armoire',sysdate(),null,1,1)
	
	
	//suc1.setUniteVente();
	//suc2.setCategorieProduit(1L);
	//Assert.assertEquals(2L, suc0.getId(), 0.1);
	suc1=dao2.findOne(1L);
	
	suc2=dao3.findOne(1L);
	suc0.setCategoriesProduct(suc2);
	suc0.setSalesUnit(suc1);
	suc0.setName("buffet");
	suc0.setDateReferencing(new Date());
	//servicereferenceproduct.AjouterReferenceProduit(suc0);


	//ReferenceProduct  rechercheReferenceProduitParIdentifiant(Long id);
	//ReferenceProduct AjouterReferenceProduit(ReferenceProduct referenceproduct);
	servicereferenceproduct.ajouterReferenceProduit(suc0);
	Assert.assertEquals(15L, suc0.getId(), 0.1);

}
}
