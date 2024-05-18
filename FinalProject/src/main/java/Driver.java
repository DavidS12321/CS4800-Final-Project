public class Driver extends User implements Observer {

	private final Shift shift;

	// Driver has everything a user has + a shift. Shift is an enum
	public Driver(String name, String address, String county, Shift shift) {
		super(name, address, county);
		this.shift = shift;
	}

	// Updates delivery status for driver
	@Override
	public void update(String status) {
		System.out.println(name + " received delivery status update: " + status);
	}

	public Shift getShift() {
		return shift;
	}

	public boolean equals(Driver other) {
		return super.equals(other) && shift.equals(other.getShift());
	}
}