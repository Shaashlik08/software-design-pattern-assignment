public class Main {
    public static void main(String[] args) {
        CoffeeMaker coffeeMaker = new CoffeeMaker(new EspressoStrategy());
        System.out.println(coffeeMaker.brew(18));

        coffeeMaker.setStrategy(new FrenchPressStrategy());
        System.out.println(coffeeMaker.brew(18));

        coffeeMaker.setStrategy(new ColdBrewStrategy());
        System.out.println(coffeeMaker.brew(18));
    }
}
