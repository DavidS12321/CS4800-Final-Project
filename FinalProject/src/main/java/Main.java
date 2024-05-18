import java.time.LocalTime;
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
		customers.add((Customer) UserFactory.createUser("Customer", "Bob", "456 Elm St", "San Bernardino County", null, DietaryRestriction.NO_RESTRICTION, null, null, null, null));
		customers.add((Customer) UserFactory.createUser("Customer", "Carol", "789 Maple St", "Orange County", null, DietaryRestriction.NUT_ALLERGY, null, null, null, null));
		customers.add((Customer) UserFactory.createUser("Customer", "Dave", "101 Oak St", "Orange County", null, DietaryRestriction.PALEO, null, null, null, null));
		customers.add((Customer) UserFactory.createUser("Customer", "Eve", "102 Pine St", "LA County", null, DietaryRestriction.VEGAN, null, null, null, null));
		customers.add((Customer) UserFactory.createUser("Customer", "Frank", "103 Birch St", "San Bernardino County", null, DietaryRestriction.NO_RESTRICTION, null, null, null, null));
		customers.add((Customer) UserFactory.createUser("Customer", "Grace", "104 Cedar St", "LA County", null, DietaryRestriction.NUT_ALLERGY, null, null, null, null));
		customers.add((Customer) UserFactory.createUser("Customer", "Hank", "105 Walnut St", "San Bernardino County", null, DietaryRestriction.PALEO, null, null, null, null));
		customers.add((Customer) UserFactory.createUser("Customer", "Ivy", "106 Chestnut St", "Orange County", null, DietaryRestriction.VEGAN, null, null, null, null));
		customers.add((Customer) UserFactory.createUser("Customer", "Jack", "107 Fir St", "LA County", null, DietaryRestriction.NO_RESTRICTION, null, null, null, null));

		// Create drivers
		List<Driver> drivers = new ArrayList<>();
		drivers.add((Driver) UserFactory.createUser("Driver", "Driver 1", "201 Oak St", "San Bernardino County", Shift.FIRST_SHIFT, null, null, null, null, null));
		drivers.add((Driver) UserFactory.createUser("Driver", "Driver 2", "202 Pine St", "LA County", Shift.SECOND_SHIFT, null, null, null, null, null));
		drivers.add((Driver) UserFactory.createUser("Driver", "Driver 3", "203 Birch St", "Orange County", Shift.THIRD_SHIFT, null, null, null, null, null));
		drivers.add((Driver) UserFactory.createUser("Driver", "Driver 4", "204 Cedar St", "Orange County", Shift.FIRST_SHIFT, null, null, null, null, null));
		drivers.add((Driver) UserFactory.createUser("Driver", "Driver 5", "205 Walnut St", "San Bernardino County", Shift.SECOND_SHIFT, null, null, null, null, null));
		drivers.add((Driver) UserFactory.createUser("Driver", "Driver 6", "206 Chestnut St", "LA County", Shift.THIRD_SHIFT, null, null, null, null, null));
		drivers.add((Driver) UserFactory.createUser("Driver", "Driver 7", "207 Fir St", "Orange County", Shift.FIRST_SHIFT, null, null, null, null, null));
		drivers.add((Driver) UserFactory.createUser("Driver", "Driver 8", "208 Oak St", "LA County", Shift.SECOND_SHIFT, null, null, null, null, null));

		// Create restaurants
		List<Restaurant> restaurants = new ArrayList<>();
		restaurants.add((Restaurant) UserFactory.createUser("Restaurant", "Restaurant 1", "301 Cedar St", "LA County", null, null, "00:00 - 23:59", "American", menuOne, meals));
		restaurants.add((Restaurant) UserFactory.createUser("Restaurant", "Restaurant 2", "302 Cedar St", "Orange County", null, null, "00:00 - 23:59", "Mexican", menuOne, meals));
		restaurants.add((Restaurant) UserFactory.createUser("Restaurant", "Restaurant 3", "303 Cedar St", "San Bernardino County", null, null, "00:00 - 23:59", "American", menuOne, meals));
		restaurants.add((Restaurant) UserFactory.createUser("Restaurant", "Restaurant 4", "304 Cedar St", "LA County", null, null, "00:00 - 23:59", "Asian", menuOne, meals));

		// Initialize OrderManager and add observers
		OrderManager orderManager = OrderManager.getInstance();
		customers.forEach(orderManager::addObserver);
		drivers.forEach(orderManager::addObserver);

		// Create and print orders
		for (Customer customer : customers) {
			boolean orderPlaced = false;
			while (!orderPlaced) {
				Restaurant restaurant = restaurants.get(new Random().nextInt(restaurants.size()));
				Driver availableDriver = findAvailableDriver(drivers, restaurant.getOperatingHours(), customer.getCounty());

				if (availableDriver != null) {
					Order order = new Order(restaurant, customer, availableDriver);
					if (order.placeOrder()) {
						order.printOrder(order);
						orderPlaced = true;
					} else {
						System.out.println("Order could not be placed for customer: " + customer.getName());
					}
				} else {
					System.out.println("No available driver for customer: " + customer.getName());
					orderPlaced = true;  // Exit loop if no driver is available
				}
			}
		}
	}

	private static Driver findAvailableDriver(List<Driver> drivers, String operatingHours, String county) {
		LocalTime currentTime = LocalTime.now();
		LocalTime openingTime = LocalTime.parse(operatingHours.split(" - ")[0]);
		LocalTime closingTime = LocalTime.parse(operatingHours.split(" - ")[1]);

		for (Driver driver : drivers) {
			if (!driver.getCounty().equals(county)) {
				continue;
			}

			LocalTime shiftStartTime = LocalTime.parse(driver.getShift().getStartTime());
			LocalTime shiftEndTime = LocalTime.parse(driver.getShift().getEndTime());

			if (shiftStartTime.isBefore(shiftEndTime)) {
				if (!currentTime.isBefore(shiftStartTime) && !currentTime.isAfter(shiftEndTime) &&
						!currentTime.isBefore(openingTime) && !currentTime.isAfter(closingTime)) {
					return driver;
				}
			} else {
				if ((!currentTime.isBefore(shiftStartTime) || !currentTime.isAfter(shiftEndTime)) &&
						(!currentTime.isBefore(openingTime) && !currentTime.isAfter(closingTime))) {
					return driver;
				}
			}
		}
		return null;
	}
}