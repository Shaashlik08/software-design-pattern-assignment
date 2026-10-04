public class Main {

    public static void prepareStarterKit(AdoptionKitFactory kitFactory, String petName) {
        System.out.println("\nPreparing starter kit for adoption...");
        Pet pet = kitFactory.createPet(petName);
        PetFood food = kitFactory.createFood();
        PetToy toy = kitFactory.createToy();

        System.out.println(pet);
        food.eat();
        toy.play();
        System.out.println("Starter kit ready.");
    }

    public static void main(String[] args) {
        System.out.println("=== 1. Testing Builder ===");
        Pet korolevskaya = new PetBuilder()
                .setName("Korolevskayasobaka")
                .setSpecies("Dog")
                .setBreed("Corgi")
                .setGender("Male")
                .setAgeYears(2)
                .setVaccinated(true)
                .setPassportReady(true)
                .build();
        System.out.println(korolevskaya);

        System.out.println("\n=== 2. Testing Factory Method ===");
        PetFactory dogFactory = new DogFactory();
        dogFactory.registerPet("Aktos");

        PetFactory catFactory = new CatFactory();
        catFactory.registerPet("Whiskers");

        System.out.println("\n=== 3. Testing Abstract Factory ===");
        AdoptionKitFactory dogKit = new DogAdoptionKitFactory();
        prepareStarterKit(dogKit, "Pochita");

        AdoptionKitFactory catKit = new CatAdoptionKitFactory();
        prepareStarterKit(catKit, "Luna");
    }
}