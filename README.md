#Part One: Food Delivery App

#Design Patterns Used

#1. Singleton Pattern
The Singleton Pattern is used to manage orders through the OrderManager class. This pattern ensures that there is only one instance of the OrderManager class throughout the application, providing a global point of access to it.

public class OrderManager {
    private static OrderManager instance;

    private OrderManager() {}

    public static OrderManager getInstance() {
        if (instance == null) {
            instance = new OrderManager();
        }
        return instance;
    }
}

#2. Decorator Pattern
The Decorator Pattern is utilized to add toppings to meals dynamically. This pattern allows for the extension of meal functionalities by wrapping them with additional behaviors.

public abstract class ToppingDecorator implements Meal {
    protected Meal decoratedMeal;

    public ToppingDecorator(Meal meal) {
        this.decoratedMeal = meal;
    }

    public String getDescription() {
        return decoratedMeal.getDescription();
    }
}

public class LemonTopping extends ToppingDecorator {
    public LemonTopping(Meal meal) {
        super(meal);
    }

    @Override
    public String getDescription() {
        return decoratedMeal.getDescription() + ", with Lemon Topping";
    }
}


#3. Factory Pattern
The Factory Pattern is used to create instances of different user types such as customers, drivers, and restaurants. This pattern provides a way to encapsulate the instantiation logic and return objects of a common interface.

public class UserFactory {
    public static User createUser(String type, String name, String address, String county, Shift shift, DietaryRestriction dietaryRestriction,
                                  String operatingHours, String cuisineType, List<Meal> menu, Map<String, List<String>> meals) {
        switch (type) {
            case "Customer":
                return new Customer(name, address, county, dietaryRestriction);
            case "Driver":
                return new Driver(name, address, county, shift);
            case "Restaurant":
                return new Restaurant(name, address, county, operatingHours, cuisineType, menu, meals);
            default:
                throw new IllegalArgumentException("Unknown user type");
        }
    }
}

#4. Observer Pattern
The Observer Pattern is implemented to allow customers and drivers to receive updates about their orders. The OrderManager class maintains a list of observers and notifies them of any changes to the orders.

public class OrderManager {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers(Order order) {
        for (Observer observer : observers) {
            observer.update(order);
        }
    }
}
