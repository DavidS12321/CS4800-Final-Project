import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class userFactoryTest {
    
    @Test 
    public void testUserFactorySame()
    {
        User user1 = UserFactory.createUser("Customer", "Test", "Test House", "LA County", null, DietaryRestriction.NO_RESTRICTION, null, null, null, null);
        User user2 = UserFactory.createUser("Customer", "Test", "Test House", "LA County", null, DietaryRestriction.NO_RESTRICTION, null, null, null, null);
        assertTrue(user1.equals(user2));
    }

    @Test 
    public void testUserFactoryDif()
    {
        Customer user1 = (Customer) UserFactory.createUser("Customer", "Test", "Test House", "LA County", null, DietaryRestriction.NO_RESTRICTION, null, null, null, null);
        Customer user2 = (Customer) UserFactory.createUser("Customer", "Test", "Test House", "LA County", null, DietaryRestriction.NUT_ALLERGY, null, null, null, null);
        assertFalse(user1.equals(user2));
    }
}
