package fr.afcepf.al32.groupe2.test;

import java.util.Date;
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

import fr.afcepf.al32.groupe2.dao.ClientDao;
import fr.afcepf.al32.groupe2.dao.IReservationDao;
import fr.afcepf.al32.groupe2.entity.Client;
import fr.afcepf.al32.groupe2.entity.Reservation;
import fr.afcepf.al32.groupe2.test.config.TestConfig;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfig.class)
@AutoConfigureTestDatabase

public class ReservationDaoTest {
	@Autowired
	private IReservationDao dao1;
	@Autowired
	private ClientDao dao2;
//			

	@Test
	public void findOneTest() {
		Reservation su = dao1.findOne(1L);
		Assert.assertNotNull(su);
	}

	@Test
	public void findAllTest() {
		List<Reservation> suc = dao1.findAll();
		Assert.assertNotNull(suc);
	}

	@Test
	@Transactional
	public void createOneTest() {
		Client su1 = new Client();
		Reservation su0 = new Reservation();
		

		su1 = dao2.findOne(1L);
		su0.setClient(su1);
		
		su0.setDateCreation(new Date());
		su0.setWithdrawalCode("1");

		dao1.createOne(su0);
		// 14 +14
		// Assert.assertEquals(29L, su0.getId(), 0.1);
		List<Reservation> su2 = dao1.findAll();
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
