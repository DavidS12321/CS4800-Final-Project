import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class orderTest {
    List<Meal> menuOne = new ArrayList<>();
    Map<String, List<String>> meals = new HashMap<>();
    
    @Test 
    public void testPlaceOrder()
    {
        Restaurant restaurant = new Restaurant("Test Restaurant", "Fake Address", "LA County", "00:00 - 23:59", "Cuisine 1", menuOne, meals);
        Customer customer = new Customer("Fake Name", "Fake Apartment", "LA County", DietaryRestriction.NO_RESTRICTION);
        Driver driver = new Driver("Driver", "Restaurant Address", "LA County", Shift.FIRST_SHIFT);

        Order orderTest = new Order(restaurant, customer,driver);

        boolean orderPlaced = orderTest.placeOrder();
        assertTrue(orderPlaced);


    }
}
