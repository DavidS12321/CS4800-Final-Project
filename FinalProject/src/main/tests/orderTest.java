import java.util.Random;

import org.junit.Test;

public class orderTest {
    
    
    @Test 
    public void testPlaceOrder()
    {
        Restaurant testRestaurant = new Restaurant("Testaurant", "Test Address", "LA County", "08:00 - 22:00", null, null, null);
        DietaryRestriction testDR = DietaryRestriction.NO_RESTRICTION;
        Customer testCustomer = new Customer("Testomer", "Fake House Ave", "LA County", testDR);
        Shift testShift = Shift.FIRST_SHIFT;
        Driver testDriver = new Driver("Testriver", "Fake Apartment Ave", "LA County", testShift);
        Order testOrder = new Order(testRestaurant, testCustomer, testDriver);

        boolean testVariable = testOrder.placeOrder();
        boolean expected = true;
        assertEquals(expected, testVariable);
    }

    
}
