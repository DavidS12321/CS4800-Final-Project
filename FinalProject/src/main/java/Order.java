import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Order {
    private final Restaurant restaurant;
    private final Customer customer;
    private final Driver driver;
    private DietaryRestriction dietaryRestriction;
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

    // Add a food item to the order
    public void addFoodItem(String foodItem) {
        this.foodItems.add(foodItem);
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
}