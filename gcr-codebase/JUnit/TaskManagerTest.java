package JUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.*;


public class TaskManagerTest {

    TaskManager tm = new TaskManager();

    @Test
    @Timeout(2)
    void testLongRunningTaskTimeout() {
        tm.longRunningTask();
    }
}
