package JUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringUtilsTest {

	StringUtils su = new StringUtils();
	@Test
	void testReverse() {
		assertEquals("olleh", su.reverse("hello"));
	}

	@Test
	void testIsPalindrome() {
		assertTrue(su.isPalindrome("madam"));
		assertFalse(su.isPalindrome("hello"));
	}

	@Test
	void testToUpperCase() {
		assertEquals("HELLO",su.toUpperCase("hello"));
	}

}
