package fr.afcepf.al32.groupe2.test.factory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fr.afcepf.al32.groupe2.entity.PromotionType;
import fr.afcepf.al32.groupe2.service.factory.PromotionTypeFactory;
import fr.afcepf.al32.groupe2.test.config.TestConfig;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=TestConfig.class)
@AutoConfigureTestDatabase
@Ignore
public class PromotionTypeFactoryTest {
	
	@Test
	public static void getsetPromoType() {

		PromotionTypeFactory promoTypeFactory = PromotionTypeFactory.getPromotionType();
		try {

			PromotionType promoType1 = promoTypeFactory.fabrique("percentType");
			promoType1.type();
			Method methodeSet = promoType1.getClass().getMethod("setPercentValue", Double.class);
			Double toto = (Double) methodeSet.invoke(promoType1, 20.0);

			Method methode = promoType1.getClass().getMethod("getPercentValue", null);
			Double test = (Double) methode.invoke(promoType1, null);
			System.out.println(test);
			System.out.println(promoType1.getClass());
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
