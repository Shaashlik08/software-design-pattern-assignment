public class DogFactory extends PetFactory {
    @Override
    public Pet createPet(String name) {
        return new PetBuilder()
                .setName(name)
                .setSpecies("Dog")
                .setBreed("Corgi")
                .setGender("Male")
                .setAgeYears(2)
                .setVaccinated(true)
                .setPassportReady(true)
                .build();
    }
}