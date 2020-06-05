package demotdd;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;

public class CalculatriceServiceTest {

	private CalculatriceService calculatrice;
	
/*
	@Before
	public void setUp() { //SETUP
		calculatrice = new CalculatriceService();
		System.out.println("setUp");
		}
	
	@Test(timeout = 20)
	public void testAddition() {
		//fail("not implemented");
		int resultat = calculatrice.addition(5,6); //EXCERCISE
		assertEquals(resultat,11);
	}
	
	@Ignore
	@Test(expected = ArithmeticException.class)
	public void testDivision() {
		//fail("not implemented");
		calculatrice.division(10,0);
		System.out.println("division Fait");
		
	}
	
	
	
	@After
	public void tearDown() {
		System.out.println("tesrDown");
		calculatrice= null;
	}
	*/
	
	@BeforeEach
	public void setUp() { //SETUP
		calculatrice = new CalculatriceService();
		System.out.println("setUp");
		}
	
	@Test
	public void testAddition() {
		//fail("not implemented");
		int resultat = calculatrice.addition(6, 5);
		Assertions.assertTimeout(Duration.ofMillis(10), ()->assertEquals(11, resultat));
		
	}
	
	
	@Disabled
	@Test
	public void testDivision() {
		//fail("not implemented");
		Assertions.assertThrows(ArithmeticException.class,()->calculatrice.division(10,0));
		System.out.println("division Fait");
		
	}
	
	
	@AfterEach
	public void tearDown() {
		System.out.println("tesrDown");
		calculatrice= null;
	}
}
