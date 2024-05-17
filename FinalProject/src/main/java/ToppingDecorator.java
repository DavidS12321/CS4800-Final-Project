public abstract class ToppingDecorator implements Meal {
    protected Meal decoratedMeal;

    public ToppingDecorator(Meal meal) {
        this.decoratedMeal = meal;
    }

    @Override
    public String getDescription() {
        return decoratedMeal.getDescription();
    }
}