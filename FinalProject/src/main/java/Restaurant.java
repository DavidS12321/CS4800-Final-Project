import java.time.LocalTime;
import java.util.List;
import java.util.Map;

public class Restaurant extends User {
	private final String operatingHours;
	private final String cuisineType;
	private final List<Meal> menu;
	private final Map<String, List<String>> meals;

	// Restaurant has everything a user has + operatingHours, cuisineType, menu, and meals
	public Restaurant(String name, String address, String county, String operatingHours, String cuisineType, List<Meal> menu, Map<String, List<String>> meals) {
		super(name, address, county);
		this.operatingHours = operatingHours;
		this.cuisineType = cuisineType;
		this.menu = menu;
		this.meals = meals;
	}

	public String getOperatingHours() {
		return operatingHours;
	}

	public String getCuisineType() {
		return cuisineType;
	}

	public List<Meal> getMenu() {
		return menu;
	}

	public Map<String, List<String>> getMeals() {
		return meals;
	}
	public boolean isOpen() {
		LocalTime now = LocalTime.now();
		throw new RuntimeException("Not implemented yet");
	}
	public boolean equals(Restaurant other) {
		return super.equals(other);
	}
}