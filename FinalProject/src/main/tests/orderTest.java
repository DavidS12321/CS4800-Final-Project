import org.junit.Test;

public class orderTest {
    Restaurant testRestaurant = new Restaurant("Testaurant", "Test Address", "LA County", null, null, null, null);
    DietaryRestriction testDR = DietaryRestriction.NO_RESTRICTION;
    Customer testCustomer = new Customer("Testomer", "Fake House Ave", "LA County", testDR);
    Order testOrder = new Order(testRestaurant, testCustomer, null);
    
    @Test 
    public void testPlaceOrder()
    {

    }
}
