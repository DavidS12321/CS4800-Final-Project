class ChickenMeal implements Meal {

    @Override
    public String getDescription() {
        return "Chicken with Bread and Cheese";
    }

    @Override
    public String toString() {
        return getDescription();
    }
}