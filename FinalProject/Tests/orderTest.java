import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class orderTest {
    List<Meal> menuOne = new ArrayList<>();
    Map<String, List<String>> meals = new HashMap<>();
    
    @Test 
    public void testPlaceOrder()
    {
        Restaurant restaurant = new Restaurant("Test Restaurant", "Fake Address", "LA County", "00:00 - 08:00", "Cuisine 1", menuOne, meals);
        Customer customer = new Customer("Fake Name", "Fake Apartment", "LA County", DietaryRestriction.NO_RESTRICTION);
        Driver driver = new Driver("Driver", "Restaurant Address", "LA County", Shift.FIRST_SHIFT);

        Order orderTest = new Order(restaurant, driver, customer);

        Boolean orderPlaced = orderTest.placeOrder();
        assertTrue(true, orderPlaced);


    }
}
