import java.util.*;

public class DietaryRestrictions {
    private static final Map<DietaryRestriction, Set<String>> restrictionsMap = new HashMap<>();

    static {
        restrictionsMap.put(DietaryRestriction.NO_RESTRICTION, new HashSet<>());
        restrictionsMap.put(DietaryRestriction.PALEO, new HashSet<>(Arrays.asList("Bread", "Cheese", "Lentils", "Tofu")));
        restrictionsMap.put(DietaryRestriction.VEGAN, new HashSet<>(Arrays.asList("Fish", "Chicken", "Beef", "Cheese", "Tuna")));
        restrictionsMap.put(DietaryRestriction.NUT_ALLERGY, new HashSet<>(Arrays.asList("Peanuts", "Pistachio")));
    }

    public static boolean isRestricted(String ingredient, DietaryRestriction dietaryRestriction) {
        return restrictionsMap.getOrDefault(dietaryRestriction, Collections.emptySet()).contains(ingredient);
    }
}