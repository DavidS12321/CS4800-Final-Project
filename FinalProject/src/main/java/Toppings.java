public class Toppings {
    public static class LemonTopping extends ToppingDecorator {
        public LemonTopping(Meal meal) {
            super(meal);
        }

        @Override
        public String getDescription() {
            return decoratedMeal.getDescription() + ", with Lemon Topping";
        }
    }

    public static class ExtraRiceTopping extends ToppingDecorator {
        public ExtraRiceTopping(Meal meal) {
            super(meal);
        }

        @Override
        public String getDescription() {
            return decoratedMeal.getDescription() + ", with extra rice";
        }
    }

    public static class ExtraTofuTopping extends ToppingDecorator {
        public ExtraTofuTopping(Meal meal) {
            super(meal);
        }

        @Override
        public String getDescription() {
            return decoratedMeal.getDescription() + ", with extra tofu";
        }
    }

    public static class ExtraCheeseTopping extends ToppingDecorator {
        public ExtraCheeseTopping(Meal meal) {
            super(meal);
        }

        @Override
        public String getDescription() {
            return decoratedMeal.getDescription() + ", with extra cheese";
        }
    }

    public static class KetchupTopping extends ToppingDecorator {
        public KetchupTopping(Meal meal) {
            super(meal);
        }

        @Override
        public String getDescription() {
            return decoratedMeal.getDescription() + ", with ketchup";
        }
    }

}
