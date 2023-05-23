import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.util.Random;

import org.junit.jupiter.api.RepeatedTest;

public class CalculatorTest {
	
	Random rnd = new Random();
	
	float randomNum1 = rnd.nextFloat(-1, 10);
	float randomNum2 = rnd.nextFloat(-1, 10);
	
	float a;
	
	@RepeatedTest(10)		
	public void addTest() throws Exception {
		
		a = Calculator.add(randomNum1, randomNum2);
		assumeTrue(a > 0);
		
		final float attRes = randomNum1 + randomNum2;
		
		final float res = a;
		
		assertEquals(attRes, res, "Somma tra numeri float");
	}
	
	@RepeatedTest(10)
	public void getDivExcTest() throws Exception {
		a = Calculator.add(randomNum1, randomNum2);
		assumeTrue(a < 0);
		
		assertThrows(Exception.class,
				() -> Calculator.add(randomNum1, randomNum2),
				"Deve sollevare eccezione");
	}

}
