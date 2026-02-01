package JUnit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

class ListManagerTest {
	ListManager manager = new ListManager();

	@Test
	void testAddElement() {
		List<Integer> list = new ArrayList<>();
		manager.addElement(list, 10);
		assertTrue(list.contains(10));
	    assertEquals(1, manager.getSize(list));
	}

	@Test
	void testRemoveElement() {
		List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);

        manager.removeElement(list, 10);

        assertFalse(list.contains(10));
        assertEquals(1, manager.getSize(list));
	}

	@Test
	void testGetSize() {
		List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(15);
        list.add(25);

        assertEquals(3, manager.getSize(list));
	}

}
