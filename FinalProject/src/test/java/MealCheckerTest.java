import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MealCheckerTest {

    @Test
    void testIsMealSuitableForVegan() {
        assertTrue(MealChecker.isMealSuitable("Tofu with Lentils and Avocado", DietaryRestriction.VEGAN));
        assertFalse(MealChecker.isMealSuitable("Fish with Rice and Avocado", DietaryRestriction.VEGAN));
        assertFalse(MealChecker.isMealSuitable("Chicken with Bread and Cheese", DietaryRestriction.VEGAN));
        assertFalse(MealChecker.isMealSuitable("Beef with Pistachio and Tuna", DietaryRestriction.VEGAN));
    }

    @Test
    void testIsMealSuitableForPaleo() {
        assertTrue(MealChecker.isMealSuitable("Fish with Avocado", DietaryRestriction.PALEO));
        assertTrue(MealChecker.isMealSuitable("Chicken with Avocado", DietaryRestriction.PALEO));
        assertFalse(MealChecker.isMealSuitable("Fish with Bread and Avocado", DietaryRestriction.PALEO));
        assertFalse(MealChecker.isMealSuitable("Chicken with Lentils and Avocado", DietaryRestriction.PALEO));
    }

    @Test
    void testIsMealSuitableForNutAllergy() {
        assertTrue(MealChecker.isMealSuitable("Fish with Rice and Avocado", DietaryRestriction.NUT_ALLERGY));
        assertFalse(MealChecker.isMealSuitable("Chicken with Bread and Pistachio", DietaryRestriction.NUT_ALLERGY));
        assertTrue(MealChecker.isMealSuitable("Tofu with Lentils and Avocado", DietaryRestriction.NUT_ALLERGY));
    }

    @Test
    void testIsMealSuitableForNoRestriction() {
        assertTrue(MealChecker.isMealSuitable("Fish with Rice and Avocado", DietaryRestriction.NO_RESTRICTION));
        assertTrue(MealChecker.isMealSuitable("Chicken with Bread and Cheese", DietaryRestriction.NO_RESTRICTION));
        assertTrue(MealChecker.isMealSuitable("Beef with Pistachio and Tuna", DietaryRestriction.NO_RESTRICTION));
        assertTrue(MealChecker.isMealSuitable("Tofu with Lentils and Avocado", DietaryRestriction.NO_RESTRICTION));
    }
}