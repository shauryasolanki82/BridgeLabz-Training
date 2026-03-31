package JUnit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CalculatorTest {

	@Test
	void testAdd() {
		Calculator calc = new Calculator();
		assertEquals(5,calc.add(2, 3));
	}
	
	@Test
	void testSubtract() {
		Calculator calc = new Calculator();
		assertEquals(1,calc.subtract(3, 2));
	}
	
	@Test
	void testMultiply() {
		Calculator calc = new Calculator();
		assertEquals(6,calc.multiply(3, 2));
	}
	
	@Test
	void testDivide() {
		Calculator calc = new Calculator();
		assertEquals(2,calc.divide(6, 3));
	}
	
	@Test
	void testDevideByZero() {
		Calculator calc = new Calculator();
		assertThrows(ArithmeticException.class, () ->{
			calc.divide(10,0);
		});
	}

}
