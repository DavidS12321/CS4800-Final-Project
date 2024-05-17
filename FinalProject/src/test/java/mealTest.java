import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;


public class mealTest {
    
    
    @Test
    public void testGetDescriptionBeef()
    {
        Meal beefMeal = new BeefMeal();
        String expectedBeef = "Beef with Pistachio and Tuna";
        String testGDBeef = beefMeal.getDescription();
        assertEquals(expectedBeef, testGDBeef);
    }

    @Test 
    public void testGetDescriptionChickenMeal()
    {
        Meal chickenMeal = new ChickenMeal();
        String expectedChicken = "Chicken with Bread and Cheese";
        String testGDChicken = chickenMeal.getDescription();
        assertEquals(expectedChicken, testGDChicken);
    }

    @Test 
    public void testGetDescriptionFishMeal()
    {
        Meal fishMeal = new FishMeal();
        String expectedFishMeal = "Fish with Rice and Avocado";
        String testGDFish = fishMeal.getDescription();
        assertEquals(expectedFishMeal, testGDFish);
    }

    @Test 
    public void testGetDescriptionTofuMeal()
    {
        Meal tofuMeal = new TofuMeal();
        String expectedTofuMeal = "Tofu with Lentils and Avocado";
        String testGDTofu = tofuMeal.getDescription();
        assertEquals(expectedTofuMeal, testGDTofu);
    }

    @Test 
    public void testLemonTopping()
    {
        Meal chickenMeal = new ChickenMeal();
        Meal chickenMealWithLemon = new Toppings.LemonTopping(chickenMeal);
        String expected = "Chicken with Bread and Cheese, with Lemon Topping";
        String testGD = chickenMealWithLemon.getDescription();
        assertEquals(expected, testGD);
    }

    @Test 
    public void testRiceTopping()
    {
        Meal tofuMeal = new TofuMeal();
        Meal tofuMealwithRice = new Toppings.ExtraRiceTopping(tofuMeal);
        String expected = "Tofu with Lentils and Avocado, with extra rice";
        String testGD = tofuMealwithRice.getDescription();
        assertEquals(expected, testGD);
    }

    @Test 
    public void testTofuTopping()
    {
        Meal tofuMeal = new TofuMeal();
        Meal tofuMealwithTofu = new Toppings.ExtraTofuTopping(tofuMeal);
        String expected = "Tofu with Lentils and Avacado, with extra tofu";
        String testGD = tofuMealwithTofu.getDescription();
        assertEquals(expected, testGD);
    }

    @Test 
    public void testCheeseTopping()
    {
        Meal beefMeal = new BeefMeal();
        Meal beefMealwithCheese = new Toppings.ExtraCheeseTopping(beefMeal);
        String expected = "Beef with Pistachio and Tuna, with extra cheese";
        String testGD = beefMealwithCheese.getDescription();
        assertEquals(expected, testGD);
    }

    @Test 
    public void testKetchupTopping()
    {
        Meal chickenMeal = new ChickenMeal();
        Meal chickenMealwithKetchup = new Toppings.KetchupTopping(chickenMeal);
        String expected = "Chicken with Bread and Cheese, with ketchup";
        String testGD = chickenMealwithKetchup.getDescription();
        assertEquals(expected, testGD);
    }



}
