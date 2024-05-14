public class Customer {

	private String name=null;
	private String address=null;
	private String county=null; 
	private String dietaryRestriction=null; // should be an enum?

	public Customer(String name) {
		this.name=name;
	}
}