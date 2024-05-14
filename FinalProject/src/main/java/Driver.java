import java.time.*;

public class Driver {

	public final String name=null;
	private LocalTime startShiftTime=null;
	private LocalTime endShiftTime=null;
	private String county=null;
	private boolean currentlyDriving=false;

	public boolean isAvailable() {
		LocalTime now = LocalTime.now();
		return !currentlyDriving && now.compareTo(startShiftTime)>=0 && now.compareTo(endShiftTime)<0;
	}

	public void startDrive() {
		currentlyDriving=true;
	}

	public void endDrive() {
		currentlyDriving=false;
	}
}