import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class UserFactoryTest {

    private List<Meal> menu;
    private Map<String, List<String>> meals;

    @BeforeEach
    void setUp() {
        menu = Arrays.asList(new FishMeal(), new TofuMeal());
        meals = new HashMap<>();
    }

    @Test
    void testCreateCustomer() {
        User user = UserFactory.createUser("Customer", "John Doe", "123 Main St", "LA County", null, DietaryRestriction.VEGAN, null, null, null, null);
        assertTrue(user instanceof Customer);
        Customer customer = (Customer) user;
        assertEquals("John Doe", customer.getName());
        assertEquals("123 Main St", customer.getAddress());
        assertEquals("LA County", customer.getCounty());
        assertEquals(DietaryRestriction.VEGAN, customer.getDietaryRestriction());
    }

    @Test
    void testCreateDriver() {
        User user = UserFactory.createUser("Driver", "Jane Doe", "456 Elm St", "LA County", Shift.FIRST_SHIFT, null, null, null, null, null);
        assertTrue(user instanceof Driver);
        Driver driver = (Driver) user;
        assertEquals("Jane Doe", driver.getName());
        assertEquals("456 Elm St", driver.getAddress());
        assertEquals("LA County", driver.getCounty());
        assertEquals(Shift.FIRST_SHIFT, driver.getShift());
    }

    @Test
    void testCreateRestaurant() {
        User user = UserFactory.createUser("Restaurant", "Good Eats", "789 Maple St", "LA County", null, null, "00:00 - 23:59", "Asian", menu, meals);
        assertTrue(user instanceof Restaurant);
        Restaurant restaurant = (Restaurant) user;
        assertEquals("Good Eats", restaurant.getName());
        assertEquals("789 Maple St", restaurant.getAddress());
        assertEquals("LA County", restaurant.getCounty());
        assertEquals("00:00 - 23:59", restaurant.getOperatingHours());
        assertEquals("Asian", restaurant.getCuisineType());
        assertEquals(menu, restaurant.getMenu());
        assertNotNull(restaurant.getMeals().get("Carbs"));
        assertNotNull(restaurant.getMeals().get("Protein"));
        assertNotNull(restaurant.getMeals().get("Fats"));
    }

    @Test
    void testCreateUnknownUserType() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            UserFactory.createUser("UnknownType", "John Doe", "123 Main St", "LA County", null, null, null, null, null, null);
        });
        assertEquals("Unknown user type", exception.getMessage());
    }
}
