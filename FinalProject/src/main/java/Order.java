import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Order {
    private final Restaurant restaurant;
    private final Customer customer;
    private final Driver driver;
    private final DietaryRestriction dietaryRestriction;
    private List<String> foodItems;
    private LocalDateTime orderCreationTime;
    private LocalDateTime orderPickupTime;
    private LocalDateTime orderDeliveryTime;

    public Order(Restaurant restaurant, Customer customer, Driver driver) {
        this.restaurant = restaurant;
        this.customer = customer;
        this.driver = driver;
        this.dietaryRestriction = customer != null ? customer.getDietaryRestriction() : DietaryRestriction.NO_RESTRICTION;
        this.foodItems = new ArrayList<>();
        this.orderCreationTime = LocalDateTime.now();
    }

    public boolean placeOrder() {
        LocalTime currentTime = LocalTime.now();
        LocalTime openingTime = LocalTime.parse(restaurant.getOperatingHours().split(" - ")[0]);
        LocalTime closingTime = LocalTime.parse(restaurant.getOperatingHours().split(" - ")[1]);

        if (isWithinOperatingHours(currentTime, openingTime, closingTime) && isWithinDriverShift(currentTime, driver.getShift()) && isSameCounty()) {
            this.orderCreationTime = LocalDateTime.now();
            this.orderPickupTime = this.orderCreationTime.plusHours(1); // Example: pickup time is 1 hour after creation
            this.orderDeliveryTime = this.orderPickupTime.plusHours(1); // Example: delivery time is 1 hour after pickup
            generateFoodItems();
            return true;
        }

        if (!isWithinOperatingHours(currentTime, openingTime, closingTime)) {
            System.out.println("Order cannot be placed: Current time " + currentTime + " is not within restaurant's operating hours " + restaurant.getOperatingHours());
        }
        if (!isWithinDriverShift(currentTime, driver.getShift())) {
            System.out.println("Order cannot be placed: Current time " + currentTime + " is not within driver's shift " + driver.getShift().getStartTime() + " - " + driver.getShift().getEndTime());
        }
        if (!isSameCounty()) {
            System.out.println("Order cannot be placed: Customer, restaurant, and driver are not in the same county.");
        }

        return false;
    }

    public void printOrder(Order order) {
        if (order.placeOrder()) {
            order.setOrderPickupTime(LocalDateTime.now().plusHours(1)); // Pickup time is 1 hour from now
            order.setOrderDeliveryTime(LocalDateTime.now().plusHours(2)); // Delivery time is 2 hours from now

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
            System.out.println("Driver Shift: " + order.getDriver().getShift().getStartTime() + " - " + order.getDriver().getShift().getEndTime());
            System.out.println("\n" + order.getCustomer().getName() + "'s food items in their meal: " + order.getFoodItems());
            System.out.println("Order Creation Time: " + order.getOrderCreationTime());
            System.out.println("Order Pickup Time: " + order.getOrderPickupTime());
            System.out.println("Order Delivery Time: " + order.getOrderDeliveryTime());
        }
    }

    private boolean isWithinOperatingHours(LocalTime currentTime, LocalTime openingTime, LocalTime closingTime) {
        return !currentTime.isBefore(openingTime) && !currentTime.isAfter(closingTime);
    }

    private boolean isWithinDriverShift(LocalTime currentTime, Shift shift) {
        LocalTime shiftStartTime = LocalTime.parse(shift.getStartTime());
        LocalTime shiftEndTime = LocalTime.parse(shift.getEndTime());

        if (shiftStartTime.isBefore(shiftEndTime)) {
            return !currentTime.isBefore(shiftStartTime) && !currentTime.isAfter(shiftEndTime);
        } else {
            return !currentTime.isBefore(shiftStartTime) || !currentTime.isAfter(shiftEndTime);
        }
    }

    private boolean isSameCounty() {
        return driver.getCounty().equals(restaurant.getCounty()) && driver.getCounty().equals(customer.getCounty());
    }

    // Generate food items based on dietary restriction and restaurant menu using MealService
    public void generateFoodItems() {
        Random random = new Random();
        List<Meal> suitableMeals = new ArrayList<>();
        for (Meal meal : restaurant.getMenu()) {
            if (MealChecker.isMealSuitable(meal.getDescription(), dietaryRestriction)) {
                suitableMeals.add(meal);
            }
        }

        if (!suitableMeals.isEmpty()) {
            Meal selectedMeal = suitableMeals.get(random.nextInt(suitableMeals.size()));
            int toppingCount = random.nextInt(3); // Randomly choose 0, 1, or 2 toppings
            for (int i = 0; i < toppingCount; i++) {
                int toppingType = random.nextInt(5); // Randomly choose one of the five toppings
                switch (toppingType) {
                    case 0:
                        selectedMeal = new Toppings.LemonTopping(selectedMeal);
                        break;
                    case 1:
                        selectedMeal = new Toppings.ExtraRiceTopping(selectedMeal);
                        break;
                    case 2:
                        selectedMeal = new Toppings.ExtraTofuTopping(selectedMeal);
                        break;
                    case 3:
                        selectedMeal = new Toppings.ExtraCheeseTopping(selectedMeal);
                        break;
                    case 4:
                        selectedMeal = new Toppings.KetchupTopping(selectedMeal);
                        break;
                }
            }

            foodItems.add(selectedMeal.getDescription());
        } else {
            foodItems.add("No suitable meals available");
        }
    }

    // Add a food item to the order
    public void addFoodItem(String foodItem) {
        this.foodItems.add(foodItem);
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Driver getDriver() {
        return driver;
    }

    public DietaryRestriction getDietaryRestriction() {
        return dietaryRestriction;
    }

    public List<String> getFoodItems() {
        return foodItems;
    }

    public LocalDateTime getOrderCreationTime() {
        return orderCreationTime;
    }

    public LocalDateTime getOrderPickupTime() {
        return orderPickupTime;
    }

    public LocalDateTime getOrderDeliveryTime() {
        return orderDeliveryTime;
    }

    public void setOrderPickupTime(LocalDateTime orderPickupTime) {
        this.orderPickupTime = orderPickupTime;
    }

    public void setOrderDeliveryTime(LocalDateTime orderDeliveryTime) {
        this.orderDeliveryTime = orderDeliveryTime;
    }
}