import java.util.*;
import java.time.*;
class Order {
	public final Restaurant restaurant;
	public final Customer customer;
	public final String dietaryRestriction;
	public final String[] meals;
	public final Driver driver;
	public boolean isBeingFulfilled=false;
	private LocalTime creationTime=null;
	private LocalTime pickupTime=null;
	private LocalTime deliveryTime=null;
	private Order(OrderBuilder builder) {
		creationTime=LocalTime.now();
		restaurant=builder.restaurant;
		customer=builder.customer;
		dietaryRestriction=builder.dietaryRestriction;
		meals=builder.meals.toArray(new String[0]);
	}
	public void setPickupTime() {
		pickupTime=LocalTime.now();
	}
	public void setDeliveryTime() {
		deliveryTime=LocalTime.now();
	}
	public static OrderBuilder builder() {
		return new OrderBuilder();
	}
	public class OrderBuilder {
		private Restaurant restaurant;
		private Customer customer;
		private String dietaryRestriction;
		public OrderBuilder setRestaurant(Restaurant restaurant) {
			this.restaurant=restaurant;
			return this;
		}
		public OrderBuilder setCustomer(Customer customer) {
			this.customer=customer;
			return this;
		}
		public OrderBuilder setDietaryRestriction(String diet) {
			this.dietaryRestriction=diet;
			return this;
		}	
		public Order build() {
			if (restaurant!=null&&customer!=null&&dietaryRestriction!=null)
				return new Order(this);
			throw new RuntimeException("One of the inputs was null");
		}
	}
}