import java.util.*;

public class Restaurant extends User {
	private final String operatingHours;
	private final String cuisineType;
	private final List<menuItem> menu;
	private final Map<String, List<String>> meals;

	// Restaurant has everything a user has + operatingHours, cuisineType, menu, and meals
	public Restaurant(String name, String address, String county, String operatingHours, String cuisineType, List<menuItem> menu, Map<String, List<String>> meals) {
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

	public List<menuItem> getMenu() {
		for(menuItem menuLoop : menu)
		{
			menuLoop.displayItem();
		}
		return menu;
	}

	public Map<String, List<String>> getMeals() {
		return meals;
	}
}