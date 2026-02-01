package JUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ParameterizedTestt {

	Parameterized p = new Parameterized();
	
	@ParameterizedTest
	@ValueSource(ints = {1,2,3,4,5})
	void testIseven(int num) {
		assertTrue(num%2==0 || num%2==1);
	}
	

}
