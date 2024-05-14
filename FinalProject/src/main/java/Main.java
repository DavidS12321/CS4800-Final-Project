import java.time.LocalDateTime;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		// Define dietary restrictions for a customer
		DietaryRestriction dietaryRestriction = DietaryRestriction.VEGAN;

		// Define the menu and meals for a restaurant
		List<String> menu = Arrays.asList("Topping1", "Topping2", "Topping3");
		Map<String, List<String>> meals = new HashMap<>();
		meals.put("Carbs", Arrays.asList("Cheese", "Bread", "Lentils", "Pistachio"));
		meals.put("Protein", Arrays.asList("Fish", "Chicken", "Beef", "Tofu"));
		meals.put("Fats", Arrays.asList("Avocado", "Sour cream", "Tuna", "Peanuts"));

		// Create users using the factory
		Customer customer = (Customer) UserFactory.createUser("Customer", "Alice", "123 Main St", "LA County", null, dietaryRestriction, null, null, null, null);
		Driver driver = (Driver) UserFactory.createUser("Driver", "Bob", "456 Elm St", "LA County", Shift.FIRST_SHIFT, null, null, null, null, null);
		Restaurant restaurant = (Restaurant) UserFactory.createUser("Restaurant", "The Good Food", "789 Oak St", "LA County", null, null, "9 AM - 9 PM", "Mexican", menu, meals);

		// Register observers
		OrderManager orderManager = OrderManager.getInstance();
		orderManager.addObserver(customer);
		orderManager.addObserver(driver);

		// Create an order
		Order order = new Order(restaurant, customer, driver);
		order.generateFoodItems();
		order.setOrderPickupTime(LocalDateTime.now().plusHours(1)); // Pickup time is 1 hour from now
		order.setOrderDeliveryTime(LocalDateTime.now().plusHours(2)); // Delivery time is 2 hours from now

		// Notify observers
		orderManager.notifyObservers("Order #1 is ready for pickup.");

		// Print order details
		System.out.println("\nOrder Details:");
		System.out.println("\nRestaurant: " + order.getRestaurant().getName());
		System.out.println("Restaurant Menu: " + order.getRestaurant().getMenu());
		System.out.println("Restaurant Cuisine: " + order.getRestaurant().getCuisineType());
		System.out.println("\nCustomer: " + order.getCustomer().getName());
		System.out.println("Customer Address: " + order.getCustomer().getAddress());
		System.out.println("Customer County: " + order.getCustomer().getCounty());
		System.out.println("Dietary Restriction: " + order.getDietaryRestriction());
		System.out.println("\nDriver: " + order.getDriver().getName());
		System.out.println("Driver Address: " + order.getDriver().getAddress());
		System.out.println("Driver County: " + order.getDriver().getCounty());
		System.out.println("\n" + order.getRestaurant().getName() + " Food Items: " + order.getFoodItems());
		System.out.println("Order Creation Time: " + order.getOrderCreationTime());
		System.out.println("Order Pickup Time: " + order.getOrderPickupTime());
		System.out.println("Order Delivery Time: " + order.getOrderDeliveryTime());
	}
}