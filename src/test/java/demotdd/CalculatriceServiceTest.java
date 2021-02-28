package demotdd;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.Assume;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledIf;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;


@DisplayName("class de test calculatrice")
public class CalculatriceServiceTest {

	Calculatrice calculatrice = new Calculatrice();
	
	@Test
	@DisplayName("methode d'addition")
	public void testAdditionEntier() {
		
		int resultatAddition = calculatrice.addition(2,3);
		//fail();
		assertEquals(5, resultatAddition);
	}	
	
	///Methode de test qui sera executer avnat tout test
	
	@BeforeEach
	@Test
	public void testSoustractionEntier() {
		Calculatrice calculatrice = new Calculatrice();
		int resultatAddition = calculatrice.soustraction(3,1);
		//fail();
		assertEquals(2, resultatAddition);
	}
	
	///Methode qui s'execute avant tout test
	
	@Test
	@BeforeEach
	public void sayHello() {
		System.out.println("hello");
	}
	
	///Methode qui s'execute apres tout test
	
		@Test
		@AfterEach
		public void sayBye() {
			System.out.println("Bye ! See you next");
		}
		
		// Cette methode de test s'execute que sur linux
		
		
		/*
		 * @Test
		 * 
		 * @DisabledOnOs(OS.WINDOWS) public void testEnableOnOs() { assertEquals(3,
		 * calculatrice.soustraction(5, 2)); }
		 */
		
		@Test
		@EnabledIf("true")
		public void testEnableCondition() {
			assertTrue(true);
			System.out.println("Condition ok");
		}
		
		
		
		@Test
		@Disabled("Ce test est désactivé")
		public void testDisabled() {
			assertEquals(5, calculatrice.soustraction(10, 5));
		}

		// Test  qui va s'executer en 1 position apres tout test avec l'annotation @BeforeAll 

		@Test
		@Order(1)
		public void testOrdered() {
			int resultat = calculatrice.addition(5, 5);
			assertEquals(10, resultat);
		}
		
		// Test  qui va s'executer en 2 position apres tout test avec l'annotation @BeforeAll 
		
		@Test
		@Order(2)
		public void testOrderedSecond() {
			int resultat = calculatrice.addition(6, 5);
			assertEquals(11, resultat);
		}
		
		@Test
		@RepeatedTest(2)
		public void testRepeated() {
			assertEquals(4, calculatrice.addition(2, 2));
		}
		
		@Nested
		class subClassTest{
			
			@Test
			public void firstTestInSubClass() {
				assertEquals(3, calculatrice.soustraction(6, 3));
			}
		}
		

}
