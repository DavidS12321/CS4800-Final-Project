import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerTest {

    DietaryRestriction NoRestriction = DietaryRestriction.NO_RESTRICTION;
    Customer customer = new Customer("Test Customer", "Random House", "LA County", NoRestriction);


    @Test
    public void TestGetDietaryRestriction()
    {
        DietaryRestriction test = customer.getDietaryRestriction();
        assertEquals(NoRestriction, test);
    }

}
