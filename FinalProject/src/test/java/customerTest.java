import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class customerTest {

    DietaryRestriction NoRestriction = DietaryRestriction.NO_RESTRICTION;
    Customer customer = new Customer("Test Customer", "Random House", "LA County", NoRestriction);


    @Test
    public void TestGetDietaryRestriction()
    {
        DietaryRestriction test = customer.getDietaryRestriction();
        assertEquals(NoRestriction, test);
    }

}
