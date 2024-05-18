public class FishMeal implements Meal {

    @Override
    public String getDescription() {
        return "Fish with Rice and Avocado";
    }

    @Override
    public String toString() {
        return getDescription();
    }
}