import java.util.*;

public class UserFactory {
    public static User createUser(String type, String name, String address, String county, Shift shift, DietaryRestriction dietaryRestriction,
                                  String operatingHours, String cuisineType, List<Meal> menu, Map<String, List<String>> meals) {
        switch (type) {
            case "Customer":
                return new Customer(name, address, county, dietaryRestriction);
            case "Driver":
                return new Driver(name, address, county, shift);
            case "Restaurant":
                if (meals == null) {
                    meals = new HashMap<>();
                }
                meals.put("Carbs", Arrays.asList("Cheese", "Bread", "Lentils", "Pistachio"));
                meals.put("Protein", Arrays.asList("Fish", "Chicken", "Beef", "Tofu"));
                meals.put("Fats", Arrays.asList("Avocado", "Sour cream", "Tuna", "Peanuts"));

                return new Restaurant(name, address, county, operatingHours, cuisineType, menu, meals);
            default:
                throw new IllegalArgumentException("Unknown user type");
        }
    }
}