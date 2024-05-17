import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class driverTest {
    Shift testShift = Shift.FIRST_SHIFT;

    @Test 
    public void testGetShift()
    {
        Driver driverTest = new Driver("TestDriver", "Test House", "LA County", testShift);
        Shift expectedShift = driverTest.getShift();
        assertEquals(expectedShift, testShift);
    }



}
