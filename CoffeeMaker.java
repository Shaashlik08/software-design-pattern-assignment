public class CoffeeMaker {
    private BrewingStrategy strategy;

    public CoffeeMaker(BrewingStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(BrewingStrategy strategy) {
        this.strategy = strategy;
    }

    public String brew(int coffeeGrams) {
        return strategy.brew(coffeeGrams);
    }
}
