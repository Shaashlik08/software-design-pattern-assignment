public class FrenchPressStrategy implements BrewingStrategy {
    private static final int WATER_ML_PER_GRAM = 15;

    @Override
    public String brew(int coffeeGrams) {
        return "French Press: " + coffeeGrams * WATER_ML_PER_GRAM + " ml water, 4 min";
    }
}
