import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class userFactoryTest {
    
    @Test 
    public void testUserFactorySame()
    {
        User user1 = UserFactory.createUser("Customer", "Test", "Test House", "LA Ciunty", null, DietaryRestriction.NO_RESTRICTION, null, null, null, null);
        User user2 = UserFactory.createUser("Customer", "Test", "Test House", "LA Ciunty", null, DietaryRestriction.NO_RESTRICTION, null, null, null, null);
        assertSame(user1, user2);
    }

    @Test 
    public void testUserFactoryDif()
    {
        User user1 = UserFactory.createUser("Customer", "Test", "Test House", "LA Ciunty", null, DietaryRestriction.NO_RESTRICTION, null, null, null, null);
        User user2 = UserFactory.createUser("Customer", "Test", "Test House", "LA Ciunty", null, DietaryRestriction.NUT_ALLERGY, null, null, null, null);
        assertNotSame(user1, user2);
    }
}
