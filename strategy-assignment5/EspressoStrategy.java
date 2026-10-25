public class EspressoStrategy implements BrewingStrategy {
    private static final int WATER_ML_PER_GRAM = 2;

    @Override
    public String brew(int coffeeGrams) {
        return "Espresso: " + coffeeGrams * WATER_ML_PER_GRAM + " ml water, 30 sec";
    }
}
