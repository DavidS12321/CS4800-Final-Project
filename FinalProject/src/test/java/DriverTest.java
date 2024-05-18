import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DriverTest {

    private Driver driver1;
    private Driver driver2;
    private Driver driver3;

    @BeforeEach
    void setUp() {
        driver1 = new Driver("John Doe", "123 Main St", "LA County", Shift.FIRST_SHIFT);
        driver2 = new Driver("Jane Doe", "456 Elm St", "LA County", Shift.SECOND_SHIFT);
        driver3 = new Driver("John Doe", "123 Main St", "LA County", Shift.FIRST_SHIFT);
    }

    @Test
    void testDriverCreation() {
        assertNotNull(driver1);
        assertEquals("John Doe", driver1.getName());
        assertEquals("123 Main St", driver1.getAddress());
        assertEquals("LA County", driver1.getCounty());
        assertEquals(Shift.FIRST_SHIFT, driver1.getShift());
    }

    @Test
    void testUpdate() {
        // Capture the system output to verify the update method
        final String statusUpdate = "Order delivered";
        System.setOut(new java.io.PrintStream(new java.io.ByteArrayOutputStream()) {
            @Override
            public void println(String x) {
                assertEquals("John Doe received delivery status update: Order delivered", x);
            }
        });
        driver1.update(statusUpdate);
    }

    @Test
    void testGetShift() {
        assertEquals(Shift.FIRST_SHIFT, driver1.getShift());
        assertEquals(Shift.SECOND_SHIFT, driver2.getShift());
    }

    @Test
    void testEquals() {
        assertEquals(driver1, driver3); // Should be equal because all properties are the same
        assertNotEquals(driver1, driver2); // Should not be equal because shifts are different
    }
}