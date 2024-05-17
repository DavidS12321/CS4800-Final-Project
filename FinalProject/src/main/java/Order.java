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

    // Create the order and print the details
    public void printOrder(Order order){

        if (order.placeOrder()) {
            order.generateFoodItems();
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
            System.out.println("\n" + order.getRestaurant().getName() + " Food Items: " + order.getFoodItems());
            System.out.println("Order Creation Time: " + order.getOrderCreationTime());
            System.out.println("Order Pickup Time: " + order.getOrderPickupTime());
            System.out.println("Order Delivery Time: " + order.getOrderDeliveryTime());
        }
    }

    // Check to see if order time is during restaurant's operating hours
    private boolean isWithinOperatingHours(LocalTime currentTime, LocalTime openingTime, LocalTime closingTime) {
        return !currentTime.isBefore(openingTime) && !currentTime.isAfter(closingTime);
    }

    // Check to see if order time is during driver's shift
    private boolean isWithinDriverShift(LocalTime currentTime, Shift shift) {
        LocalTime shiftStartTime = LocalTime.parse(shift.getStartTime());
        LocalTime shiftEndTime = LocalTime.parse(shift.getEndTime());

        if (shiftStartTime.isBefore(shiftEndTime)) {
            return !currentTime.isBefore(shiftStartTime) && !currentTime.isAfter(shiftEndTime);
        } else {
            return !currentTime.isBefore(shiftStartTime) || !currentTime.isAfter(shiftEndTime);
        }
    }

    private boolean isSameCounty(){
        return driver.getCounty().equals(restaurant.getCounty()) && driver.getCounty().equals(customer.getCounty());
    }

    // Selects macros depending on dietary restrictions
    private String selectProtein(Random random, DietaryRestriction dietaryRestriction) {
        switch (dietaryRestriction) {
            case NO_RESTRICTION, NUT_ALLERGY:
                String[] proteinNoRestriction = {"Fish", "Chicken", "Beef", "Tofu"};
                return proteinNoRestriction[random.nextInt(proteinNoRestriction.length)];
            case PALEO:
                String[] proteinPaleo = {"Fish", "Chicken", "Beef"};
                return proteinPaleo[random.nextInt(proteinPaleo.length)];
            case VEGAN:
                return "Tofu";
            default:
                return null;
        }
    }

    private String selectCarb(Random random, DietaryRestriction dietaryRestriction) {
        switch (dietaryRestriction) {
            case NO_RESTRICTION:
                String[] carbsNoRestriction = {"Cheese", "Bread", "Lentils", "Pistachio"};
                return carbsNoRestriction[random.nextInt(carbsNoRestriction.length)];
            case PALEO:
                return "Pistachio";
            case VEGAN:
                String[] carbsVegan = {"Bread", "Lentils"};
                return carbsVegan[random.nextInt(carbsVegan.length)];
            case NUT_ALLERGY:
                String[] carbsNutAllergy = {"Cheese", "Bread", "Lentils"};
                return carbsNutAllergy[random.nextInt(carbsNutAllergy.length)];
            default:
                return null;
        }
    }

    private String selectFat(Random random, DietaryRestriction dietaryRestriction) {
        switch (dietaryRestriction) {
            case NO_RESTRICTION:
                String[] fatsNoRestriction = {"Avocado", "Sour cream", "Tuna", "Peanuts"};
                return fatsNoRestriction[random.nextInt(fatsNoRestriction.length)];
            case PALEO:
                String[] fatsPaleo = {"Avocado", "Tuna"};
                return fatsPaleo[random.nextInt(fatsPaleo.length)];
            case VEGAN:
                return "Avocado";
            case NUT_ALLERGY:
                String[] fatsNutAllergy = {"Avocado", "Sour cream", "Tuna"};
                return fatsNutAllergy[random.nextInt(fatsNutAllergy.length)];
            default:
                return null;
        }
    }

    // Generate food items based on dietary restriction
    public void generateFoodItems() {
        Random random = new Random();
        String protein = selectProtein(random, dietaryRestriction);
        String carb = selectCarb(random, dietaryRestriction);
        String fat = selectFat(random, dietaryRestriction);

        if (protein != null) this.foodItems.add(protein);
        if (carb != null) this.foodItems.add(carb);
        if (fat != null) this.foodItems.add(fat);
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