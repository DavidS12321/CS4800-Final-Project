import java.util.*;

public class Main {
	public static void main(String[] args) {

		// Define the menu and meals
		menuItem beans = new beans("Beans");
		menuItem cheese = new cheese("Cheese");
		menuItem chili = new chili("Chili");
		menuItem chiliFlakes = new chiliFlakes("ChiliFlakes");
		menuItem choppedTomato = new choppedTomato("Chopped Tomato");
		menuItem ketchup = new ketchup("Ketchup");

		List<menuItem> menuItem1 = Arrays.asList(beans, cheese, chili);
		List<menuItem> menuItem2 = Arrays.asList(chiliFlakes, choppedTomato, ketchup);
		Map<String, List<String>> meals = new HashMap<>();
		meals.put("Carbs", Arrays.asList("Cheese", "Bread", "Lentils", "Pistachio"));
		meals.put("Protein", Arrays.asList("Fish", "Chicken", "Beef", "Tofu"));
		meals.put("Fats", Arrays.asList("Avocado", "Sour cream", "Tuna", "Peanuts"));
		meals.put("Protein 2", Arrays.asList("Avocado", "Sour cream", "Tuna", "Peanuts"));

		// Create customers
		List<Customer> customers = Arrays.asList(
				(Customer) UserFactory.createUser("Customer", "Alice", "123 Main St", "LA County", null, DietaryRestriction.VEGAN, null, null, null, null),
				(Customer) UserFactory.createUser("Customer", "Bob", "456 Elm St", "Orange County", null, DietaryRestriction.PALEO, null, null, null, null),
				(Customer) UserFactory.createUser("Customer", "Charlie", "789 Oak St", "San Bernardino County", null, DietaryRestriction.NUT_ALLERGY, null, null, null, null)
				/*(Customer) UserFactory.createUser("Customer", "David", "101 Pine St", "LA County", null, DietaryRestriction.NO_RESTRICTION, null, null, null, null),
				(Customer) UserFactory.createUser("Customer", "Eve", "202 Maple St", "Orange County", null, DietaryRestriction.VEGAN, null, null, null, null),
				(Customer) UserFactory.createUser("Customer", "Frank", "303 Birch St", "San Bernardino County", null, DietaryRestriction.PALEO, null, null, null, null),
				(Customer) UserFactory.createUser("Customer", "Grace", "404 Cedar St", "LA County", null, DietaryRestriction.NUT_ALLERGY, null, null, null, null),
				(Customer) UserFactory.createUser("Customer", "Hank", "505 Spruce St", "Orange County", null, DietaryRestriction.NO_RESTRICTION, null, null, null, null),
				(Customer) UserFactory.createUser("Customer", "Ivy", "606 Palm St", "San Bernardino County", null, DietaryRestriction.VEGAN, null, null, null, null),
				(Customer) UserFactory.createUser("Customer", "Jack", "707 Oakwood St", "LA County", null, DietaryRestriction.PALEO, null, null, null, null)*/
		);

		// Create drivers
		List<Driver> drivers = Arrays.asList(
				(Driver) UserFactory.createUser("Driver", "Driver 1", "101 Pine St", "LA County", Shift.THIRD_SHIFT, null, null, null, null, null),
				(Driver) UserFactory.createUser("Driver", "Driver 2", "202 Maple St", "Orange County", Shift.THIRD_SHIFT, null, null, null, null, null)
				/*(Driver) UserFactory.createUser("Driver", "Driver 3", "303 Birch St", "San Bernardino County", Shift.THIRD_SHIFT, null, null, null, null, null),
				(Driver) UserFactory.createUser("Driver", "Driver 4", "1140 Allen Ave", "San Bernardino County", Shift.THIRD_SHIFT, null, null, null, null, null),
				(Driver) UserFactory.createUser("Driver", "Driver 5", "800 Glenoaks Blvd", "LA County", Shift.THIRD_SHIFT, null, null, null, null, null),
				(Driver) UserFactory.createUser("Driver", "Driver 6", "521 Kellogg Drive", "San Bernardino County", Shift.THIRD_SHIFT, null, null, null, null, null),
				(Driver) UserFactory.createUser("Driver", "Driver 7", "1254 Alameda Ave", "LA County", Shift.THIRD_SHIFT, null, null, null, null, null),
				(Driver) UserFactory.createUser("Driver", "Driver 8", "619 Maple Rd", "Orange County", Shift.THIRD_SHIFT, null, null, null, null, null)*/
		);

		// Create restaurants
		List<Restaurant> restaurants = Arrays.asList(
				(Restaurant) UserFactory.createUser("Restaurant", "The Good Food", "111 Cedar St", "LA County", null, null, "00:00 - 22:00", "Mexican", menuItem1, meals),
				(Restaurant) UserFactory.createUser("Restaurant", "Healthy Eats", "222 Spruce St", "Orange County", null, null, "00:00 - 21:00", "Asian", menuItem1, meals),
				(Restaurant) UserFactory.createUser("Restaurant", "Joe's Steakhouse", "333 Palm St", "San Bernardino County", null, null, "00:00 - 20:00", "American", menuItem1, meals),
				(Restaurant) UserFactory.createUser("Restaurant", "Burger Town", "333 Palm St", "LA County", null, null, "00:00 - 20:00", "American", menuItem1, meals)
		);

		// Register observers
		OrderManager orderManager = OrderManager.getInstance();
		customers.forEach(orderManager::addObserver);
		drivers.forEach(orderManager::addObserver);


		// Create orders
		for (Customer customer : customers) {
			Random random = new Random();

			Driver driver = drivers.get(random.nextInt(drivers.size()));
			Restaurant restaurant = restaurants.get(random.nextInt(restaurants.size()));

			Order order = new Order(restaurant, customer, driver);
			order.printOrder();
		}
	}
}