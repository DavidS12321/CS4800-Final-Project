class TofuMeal implements Meal {

    @Override
    public String getDescription() {
        return "Tofu with Lentils and Avocado";
    }

    @Override
    public String toString() {
        return getDescription();
    }
}