package JUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ExceptionTest {

	@Test
	void testDivide() {
		Exception excep = new Exception();
		
		assertThrows(ArithmeticException.class,()-> excep.divide(4,0));
	}

}
