public class ColdBrewStrategy implements BrewingStrategy {
    private static final int WATER_ML_PER_GRAM = 8;

    @Override
    public String brew(int coffeeGrams) {
        return "Cold Brew: " + coffeeGrams * WATER_ML_PER_GRAM + " ml water, 12 hours";
    }
}
