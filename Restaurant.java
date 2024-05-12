import java.time.*;
import java.util.*;
class Restaurant {
	public final String name;
	public final String address=null;
	public final String county=null;
	private LocalTime openingHour=null;
	private LocalTime closingHour=null;
	public final List<String> meals=new ArrayList<>();
	public Restaurant(String name) {
		this.name=name;
	}
	public boolean isOpen() {
		LocalTime now = LocalTime.now();
		return now.compareTo(openingHour)>=0 && now.compareTo(closingHour)<=0;
	}
	public void add(String meal) {
		meals.add(meal);
	}
	public void remove(String meal) {
		meals.remove(meal);
	}
}