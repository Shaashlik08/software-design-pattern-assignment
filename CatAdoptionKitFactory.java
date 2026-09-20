public class CatAdoptionKitFactory implements AdoptionKitFactory {
    private final PetFactory catFactory = new CatFactory();

    @Override
    public Pet createPet(String name) {
        return catFactory.createPet(name);
    }

    @Override
    public PetFood createFood() {
        return new CatFood();
    }

    @Override
    public PetToy createToy() {
        return new CatToy();
    }
}