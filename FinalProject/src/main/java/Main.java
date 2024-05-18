import java.util.*;

public class Main {
	public static void main(String[] args) {
		// Define meals
		Meal fishMeal = new FishMeal();
		Meal tofuMeal = new TofuMeal();
		Meal chickenMeal = new ChickenMeal();
		Meal beefMeal = new BeefMeal();

		// Create menu
		List<Meal> menuOne = new ArrayList<>();
		menuOne.add(fishMeal);
		menuOne.add(tofuMeal);
		menuOne.add(chickenMeal);
		menuOne.add(beefMeal);

		// Create a map for food items and their categories
		Map<String, List<String>> meals = new HashMap<>();

		// Create customers
		List<Customer> customers = new ArrayList<>();
		customers.add((Customer) UserFactory.createUser("Customer", "Alice", "123 Main St", "LA County", null, DietaryRestriction.VEGAN, null, null, null, null));
		customers.add((Customer) UserFactory.createUser("Customer", "Bob", "456 Elm St", "LA County", null, DietaryRestriction.NO_RESTRICTION, null, null, null, null));
		customers.add((Customer) UserFactory.createUser("Customer", "Carol", "789 Maple St", "LA County", null, DietaryRestriction.NUT_ALLERGY, null, null, null, null));
		customers.add((Customer) UserFactory.createUser("Customer", "Dave", "101 Oak St", "LA County", null, DietaryRestriction.PALEO, null, null, null, null));
		customers.add((Customer) UserFactory.createUser("Customer", "Eve", "102 Pine St", "LA County", null, DietaryRestriction.VEGAN, null, null, null, null));
		customers.add((Customer) UserFactory.createUser("Customer", "Frank", "103 Birch St", "LA County", null, DietaryRestriction.NO_RESTRICTION, null, null, null, null));
		customers.add((Customer) UserFactory.createUser("Customer", "Grace", "104 Cedar St", "LA County", null, DietaryRestriction.NUT_ALLERGY, null, null, null, null));
		customers.add((Customer) UserFactory.createUser("Customer", "Hank", "105 Walnut St", "LA County", null, DietaryRestriction.PALEO, null, null, null, null));
		customers.add((Customer) UserFactory.createUser("Customer", "Ivy", "106 Chestnut St", "LA County", null, DietaryRestriction.VEGAN, null, null, null, null));
		customers.add((Customer) UserFactory.createUser("Customer", "Jack", "107 Fir St", "LA County", null, DietaryRestriction.NO_RESTRICTION, null, null, null, null));

		// Create drivers
		List<Driver> drivers = new ArrayList<>();
		drivers.add((Driver) UserFactory.createUser("Driver", "Driver 1", "201 Oak St", "LA County", Shift.FIRST_SHIFT, null, null, null, null, null));
		drivers.add((Driver) UserFactory.createUser("Driver", "Driver 2", "202 Pine St", "LA County", Shift.SECOND_SHIFT, null, null, null, null, null));
		drivers.add((Driver) UserFactory.createUser("Driver", "Driver 3", "203 Birch St", "LA County", Shift.THIRD_SHIFT, null, null, null, null, null));
		drivers.add((Driver) UserFactory.createUser("Driver", "Driver 4", "204 Cedar St", "LA County", Shift.FIRST_SHIFT, null, null, null, null, null));
		drivers.add((Driver) UserFactory.createUser("Driver", "Driver 5", "205 Walnut St", "LA County", Shift.SECOND_SHIFT, null, null, null, null, null));
		drivers.add((Driver) UserFactory.createUser("Driver", "Driver 6", "206 Chestnut St", "LA County", Shift.THIRD_SHIFT, null, null, null, null, null));
		drivers.add((Driver) UserFactory.createUser("Driver", "Driver 7", "207 Fir St", "LA County", Shift.FIRST_SHIFT, null, null, null, null, null));
		drivers.add((Driver) UserFactory.createUser("Driver", "Driver 8", "208 Oak St", "LA County", Shift.SECOND_SHIFT, null, null, null, null, null));

		// Create restaurants
		List<Restaurant> restaurants = new ArrayList<>();
		restaurants.add((Restaurant) UserFactory.createUser("Restaurant", "Restaurant 1", "301 Cedar St", "LA County", null, null, "00:00 - 23:59", "Cuisine 1", menuOne, meals));
		restaurants.add((Restaurant) UserFactory.createUser("Restaurant", "Restaurant 2", "302 Cedar St", "LA County", null, null, "00:00 - 23:59", "Cuisine 2", menuOne, meals));
		restaurants.add((Restaurant) UserFactory.createUser("Restaurant", "Restaurant 3", "303 Cedar St", "LA County", null, null, "00:00 - 23:59", "Cuisine 3", menuOne, meals));
		restaurants.add((Restaurant) UserFactory.createUser("Restaurant", "Restaurant 4", "304 Cedar St", "LA County", null, null, "00:00 - 23:59", "Cuisine 4", menuOne, meals));

		// Initialize OrderManager and add observers
		OrderManager orderManager = OrderManager.getInstance();
		customers.forEach(orderManager::addObserver);
		drivers.forEach(orderManager::addObserver);

		// Create and print orders
		Random random = new Random();
		for (Customer customer : customers) {
			Driver driver = drivers.get(random.nextInt(drivers.size()));
			Restaurant restaurant = restaurants.get(random.nextInt(restaurants.size()));
			Order order = new Order(restaurant, customer, driver);

			// Randomly add toppings to some meals
			Meal meal = restaurant.getMenu().get(random.nextInt(restaurant.getMenu().size()));
			int toppingCount = random.nextInt(3); // Randomly choose 0, 1, or 2 toppings
			if (toppingCount > 0) {
				meal = new Toppings.LemonTopping(meal);
			}
			if (toppingCount > 1) {
				meal = new Toppings.ExtraRiceTopping(meal);
			}

			order.addFoodItem(meal.getDescription());
			order.printOrder(order);
		}
	}
}