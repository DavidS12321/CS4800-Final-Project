import java.time.*;
class Driver {
	public final String name=null;
	private LocalTime startShiftTime=null;
	private LocalTime endShiftTime=null;
	private String county=null;
	public boolean isAvailable() {
		LocalTime now = LocalTime.now();
		return now.compareTo(startShiftTime)>=0 && now.compareTo(endShiftTime)<=0;
	}
}