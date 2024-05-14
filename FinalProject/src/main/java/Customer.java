public class Customer extends User implements Observer{

	private DietaryRestriction dietaryRestriction;

	// Customer has everything a user has + dietary restriction
	public Customer(String name, String address, String county, DietaryRestriction dietaryRestriction) {
		super(name, address, county);
		this.dietaryRestriction = dietaryRestriction;
	}

	// Updates order status for customer
	@Override
	public void update(String status){
		System.out.println(name + " received order status update: " + status);
	}

	public DietaryRestriction getDietaryRestriction() {
		return dietaryRestriction;
	}
}