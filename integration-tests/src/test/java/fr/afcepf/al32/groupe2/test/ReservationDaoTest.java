package fr.afcepf.al32.groupe2.test;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.transaction.Transactional;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fr.afcepf.al32.groupe2.dao.IBaseProductDao;
import fr.afcepf.al32.groupe2.dao.IReferenceProductDao;
import fr.afcepf.al32.groupe2.dao.IReservationDao;
import fr.afcepf.al32.groupe2.entity.BaseProduct;
import fr.afcepf.al32.groupe2.entity.Client;
import fr.afcepf.al32.groupe2.entity.Evaluation;
import fr.afcepf.al32.groupe2.entity.ReferenceProduct;
import fr.afcepf.al32.groupe2.entity.Reservation;
import fr.afcepf.al32.groupe2.entity.ReservationProduct;
import fr.afcepf.al32.groupe2.test.config.TestConfig;



	@RunWith(SpringRunner.class)
	@SpringBootTest(classes=TestConfig.class)
	@AutoConfigureTestDatabase
	public class ReservationDaoTest {
		@Autowired
		private  IReservationDao dao1;
		
//			@Autowired
//			private  IBaseProductDao dao1;
//			@Autowired
//			private  IReferenceProductDao dao2;
//			@Autowired
//			private  IBaseProductDao dao2;
//			@Autowired
//			private  IBaseProductDao dao3;
		
			@Test
			public void findOneTest() {
				Reservation su=dao1.findOne(1L);
				Assert.assertNotNull(su);
			}
			@Test
			public void findAllTest() {
				List<Reservation> suc=dao1.findAll();
				Assert.assertNotNull(suc);
			}
			@Test
			@Transactional
		public void createOneTest() {
				Reservation su0=new Reservation();
			//BaseProduct su1=new BaseProduct();
			//BaseProduct su2= new BaseProduct();
				//ReferenceProduct su1=dao2.findOne(11L);				
				//su0.setReferenceProduct(su1);
			su0.setDateCreation(new Date());
			//su0.setInitPrice(id);
			su0.setWithdrawalCode("1");
			//su0.setcodeRetraitwithdrawalCod("1")
				dao1.createOne(su0);
				//14 +14 
			//Assert.assertEquals(29L, su0.getId(), 0.1);
				List<Reservation> su2=dao1.findAll();
			Assert.assertEquals(4L, su2.size(), 0.1);
			}
//			@Id
//			@GeneratedValue(strategy=GenerationType.IDENTITY)
//			private Long id;
			
//			@Column(name="creation_date")
//			@NotBlank
//			private String dateCreation;
			
//			@Column(name="retrait_code")
//			@NotBlank
//			private String codeRetrait;
			
//			@ManyToOne(cascade= {CascadeType.PERSIST})
//			@JoinColumn(name="client_id")
//			@NotNull
//			private Client client;
			
//			@OneToOne(cascade= {CascadeType.PERSIST},mappedBy="reservation")
//			private Evaluation evaluation;
			
//			@OneToOne(cascade= {CascadeType.PERSIST},mappedBy="reservation")
//			private ReservationProduct reservationProduct;
		
			
			
			
			}
