package noyau;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationtestContext.xml")
public class VerrouTest {
	
	@Test
	public void testMd5() {
		final String password = "test";
		Assert.assertNotNull(Verrou.cryptage(password, TypeHashage.MD5));
//		Assert.assertEquals("d26da4a67d8ae5d05133973f051a70d1", Verrou.cryptage(password,TypeHashage.MD5));
	}
	
	@Test
	public void testSha512SansPreciserTypeHashage() {
		final String password = "test";
		Assert.assertEquals(128, Verrou.cryptage(password).length());
//		Assert.assertEquals("45EAA1CA28B4EACAAA5AAB9C5C75AFAC0C8F766F6C0B1F7076B8228555F07599BCA26F0057A43A939A985C1A5363E54A9CE4833FAC823D745AE02504EDB98A6E", Verrou.cryptage(password));
	}
	
	@Test
	public void testSha512() {
		final String password = "test";
		Assert.assertEquals(128, Verrou.cryptage(password,TypeHashage.SHA512).length());
//		Assert.assertEquals("45EAA1CA28B4EACAAA5AAB9C5C75AFAC0C8F766F6C0B1F7076B8228555F07599BCA26F0057A43A939A985C1A5363E54A9CE4833FAC823D745AE02504EDB98A6E", Verrou.cryptage(password,TypeHashage.SHA512));
	}
	
	@Test
	public void testSha1() {
		final String password = "test1";
		Assert.assertEquals(40, Verrou.cryptage(password,TypeHashage.SHA1).length());
//		Assert.assertEquals("45EAA1CA28B4EACAAA5AAB9C5C75AFAC0C8F766F6C0B1F7076B8228555F07599BCA26F0057A43A939A985C1A5363E54A9CE4833FAC823D745AE02504EDB98A6E", Verrou.cryptage(password,TypeHashage.SHA512));
	}
	
	@Test
	public void testSha256() {
		final String password = "test";
		Assert.assertEquals(64, Verrou.cryptage(password,TypeHashage.SHA256).length());
//		Assert.assertEquals("45EAA1CA28B4EACAAA5AAB9C5C75AFAC0C8F766F6C0B1F7076B8228555F07599BCA26F0057A43A939A985C1A5363E54A9CE4833FAC823D745AE02504EDB98A6E", Verrou.cryptage(password,TypeHashage.SHA512));
	}
	
}
