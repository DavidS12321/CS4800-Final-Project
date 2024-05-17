import java.util.*;

public class MealChecker {
    private static final Set<String> VEGAN_RESTRICTIONS = Set.of("Fish", "Chicken", "Beef", "Cheese", "Tuna");
    private static final Set<String> PALEO_RESTRICTIONS = Set.of("Bread", "Lentils");
    private static final Set<String> NUT_ALLERGY_RESTRICTIONS = Set.of("Pistachio");

    public static boolean isMealSuitable(String mealDescription, DietaryRestriction dietaryRestriction) {
        switch (dietaryRestriction) {
            case VEGAN:
                return VEGAN_RESTRICTIONS.stream().noneMatch(mealDescription::contains);
            case PALEO:
                return PALEO_RESTRICTIONS.stream().noneMatch(mealDescription::contains);
            case NUT_ALLERGY:
                return NUT_ALLERGY_RESTRICTIONS.stream().noneMatch(mealDescription::contains);
            default:
                return true;
        }
    }
}