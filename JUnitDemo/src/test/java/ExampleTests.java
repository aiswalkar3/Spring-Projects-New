import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ExampleTests {
    private List<Integer> testList;

    @BeforeEach
    public void beforeEach()
    {
        testList = new ArrayList<Integer>();
        testList.add(1);
        testList.add(2);
        testList.add(3);
    }

    @AfterEach
    public void afterEach()
    {
        testList = null;
    }

    @Test
    public void testAddZero()
    {
        int tempA = 10;
        int tempB = 0;
        int tempC = tempA + tempB;
        assertEquals(tempA, tempC);
    }

    @Test
    public void testDivideZero()
    {
        int tempA = 10;
        int tempB = 0;

        assertThrows(ArithmeticException.class, () -> {
            int tempC =tempA/tempB;
        });
    }

    @Test
    public void testListContains()
    {
        assertTrue(testList.contains(1));
        testList.remove(0);
        assertFalse(testList.contains(1));
    }
}
