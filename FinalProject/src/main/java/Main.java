import java.time.LocalDateTime;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		// Define dietary restrictions for a customer
		DietaryRestriction dietaryRestriction = DietaryRestriction.VEGAN;

		// Define the menu and meals for a restaurant
		List<String> menu = Arrays.asList("Menu item 1", "Menu item 2", "Menu item 3");
		Map<String, List<String>> meals = new HashMap<>();
		meals.put("Carbs", Arrays.asList("Cheese", "Bread", "Lentils", "Pistachio"));
		meals.put("Protein", Arrays.asList("Fish", "Chicken", "Beef", "Tofu"));
		meals.put("Fats", Arrays.asList("Avocado", "Sour cream", "Tuna", "Peanuts"));

		// Create users (customer, driver, restaurant) using the factory
		Customer customer = (Customer) UserFactory.createUser("Customer", "Alice", "123 Main St", "LA County", null, dietaryRestriction, null, null, null, null);
		Driver driver = (Driver) UserFactory.createUser("Driver", "Bob", "456 Elm St", "LA County", Shift.SECOND_SHIFT, null, null, null, null, null);
		Restaurant restaurant = (Restaurant) UserFactory.createUser("Restaurant", "The Good Grill", "789 Oak St", "LA County", null, null, "08:00 - 22:00", "Mexican", menu, meals);

		// Register observers
		OrderManager orderManager = OrderManager.getInstance();
		orderManager.addObserver(customer);
		orderManager.addObserver(driver);

		// Create an order
		Order order = new Order(restaurant, customer, driver);
		order.printOrder();
	}
}