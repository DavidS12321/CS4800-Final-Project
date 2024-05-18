import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        assertEquals("1:00;9:00",restaurant.getOperatingHours());
        assertEquals("good",restaurant.getCuisineType());
        assertEquals(menu,restaurant.getMeals());
        assertEquals(restaurant.getMeals(), meals);

    }
}
