public interface AdoptionKitFactory {
    Pet createPet(String name);
    PetFood createFood();
    PetToy createToy();
}