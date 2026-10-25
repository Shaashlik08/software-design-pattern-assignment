public class CatFactory extends PetFactory {
    @Override
    public Pet createPet(String name) {
        return new PetBuilder()
                .setName(name)
                .setSpecies("Cat")
                .setBreed("British Shorthair")
                .setGender("Female")
                .setAgeYears(1)
                .setVaccinated(true)
                .setPassportReady(false)
                .build();
    }
}