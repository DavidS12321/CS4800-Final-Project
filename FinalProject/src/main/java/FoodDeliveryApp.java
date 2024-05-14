import java.util.*;

public class FoodDeliveryApp {

	List<Customer> customers=new ArrayList<>();
	List<Driver> drivers=new ArrayList<>();
	List<Restaurant> restaurants = new ArrayList<>();
	List<Order> currentOrders = new ArrayList<>();

	public void register(Customer customer) {
		customers.add(customer);
	}

	public void register(Driver driver) {
		drivers.add(driver);
	}

	public void register(Restaurant restaurant) {
		restaurants.add(restaurant);
	}

	public void recieveOrder(Order order) {
		currentOrders.add(order);
	}
}