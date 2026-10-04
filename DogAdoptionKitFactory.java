public class DogAdoptionKitFactory implements AdoptionKitFactory {
    private final PetFactory dogFactory = new DogFactory();

    @Override
    public Pet createPet(String name) {
        return dogFactory.createPet(name);
    }

    @Override
    public PetFood createFood() {
        return new DogFood();
    }

    @Override
    public PetToy createToy() {
        return new DogToy();
    }
}