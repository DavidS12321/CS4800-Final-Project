class FoodDeliveryDriver {
	public static void main(String[] args) {
		FoodDeliveryApp cppFoodDelivery = new FoodDeliveryApp();
		cppFoodDelivery.register(new Customer("Alice"));
		Restaurant restaurant = new Restaurant("Bob's");
		restaurant.add("Burger");
		cppFoodDelivery.register(restaurant);
	}
}