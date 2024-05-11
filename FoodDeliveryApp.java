import java.util.*;
class FoodDeliveryApp {
	List<Customer> customers=new ArrayList<>();
	List<Driver> drivers=new ArrayList<>();
	List<Restaurant> restaurants = new ArrayList<>();
	public void register(Customer customer) {
		customers.add(customer);
	}
	public void register(Driver driver) {
		drivers.add(driver);
	}
	public void register(Restaurant restaurant) {
		restaurants.add(restaurant);
	}
}