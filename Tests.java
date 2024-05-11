class Tests {
	public static void main(String[] args) {
		System.out.println(testAddCustomer());
	}
	static boolean testAddCustomer() {
		Customer customer = new Customer();
		FoodDeliveryApp cppFoodDelivery = new FoodDeliveryApp();
		boolean result = false;
		try {
			cppFoodDelivery.register(customer);
			result=true;
		}
		catch (Exception e) {}
		return result;
	}
}