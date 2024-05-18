import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class mealCheckerTest {
    @Test
    public void testSuitability() {
        MealChecker mealChecker = new MealChecker();

        assertTrue(mealChecker.isMealSuitable("Fish",DietaryRestriction.PALEO));


    }
}
