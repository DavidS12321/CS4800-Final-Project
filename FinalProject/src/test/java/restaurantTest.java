import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RestaurantTest {


    @Test
    public void testFields() {
        List<Meal> menu = new ArrayList<>();
        menu.add(new BeefMeal());
        Map<String,List<String>> meals = new HashMap<>();
        List<String> strings = new ArrayList<>();
        strings.add("Beef");
        meals.put("Beef",strings);
        Restaurant restaurant = new Restaurant("Test","123 test st.","LA county", "1:00-9:00","good",menu,meals);
        assertEquals("1:00-9:00",restaurant.getOperatingHours());
        assertEquals("good",restaurant.getCuisineType());
        assertEquals(menu,restaurant.getMenu());
        assertEquals(restaurant.getMeals(), meals);
    }
    @Test
    public void testOpen() {
        List<Meal> menu = new ArrayList<>();
        menu.add(new BeefMeal());
        Map<String,List<String>> meals = new HashMap<>();
        List<String> strings = new ArrayList<>();
        strings.add("Beef");
        meals.put("Beef",strings);
        LocalTime future = LocalTime.now().plusHours(1);
        Restaurant restaurant = new Restaurant("Test","123 test st.","LA county", "1:00 -"+future.toString(),"good",menu,meals);
        assertTrue(restaurant.isOpen());
    }
}
