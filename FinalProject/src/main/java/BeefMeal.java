class BeefMeal implements Meal {

    @Override
    public String getDescription() {
        return "Beef with Pistachio and Tuna";
    }

    @Override
    public String toString() {
        return getDescription();
    }
}