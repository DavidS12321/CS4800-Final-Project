import java.time.*;
import java.util.*;
class Restaurant {
	public final String name=null;
	public final String address=null;
	public final String county=null;
	private LocalTime openingHour=null;
	private LocalTime closingHour=null;
	private List<String> meals=new ArrayList<>();
	public boolean isOpen() {
		LocalTime now = LocalTime.now();
		return now.compareTo(openingHour)>=0 && now.compareTo(closingHour)<=0;
	}
}