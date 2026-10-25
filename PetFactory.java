public abstract class PetFactory {
    public abstract Pet createPet(String name);

    public Pet registerPet(String name) {
        Pet pet = createPet(name);
        System.out.println("New pet registered: " + pet.getSpecies() + " " + pet.getName());
        return pet;
    }
}