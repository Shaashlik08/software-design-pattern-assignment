public class PetDirector {

    public Pet makeStandardPuppy(PetBuilder builder) {
        return builder
                .setName("Aktos")
                .setSpecies("Dog")
                .setBreed("Alabay")
                .setGender("Female")
                .setAgeYears(9)
                .setVaccinated(true)
                .setPassportReady(true)
                .build();
    }

    public Pet makeStrayKitten(PetBuilder builder) {
        return builder
                .setName("Whiskers")
                .setSpecies("Cat")
                .setBreed("Domestic Shorthair")
                .setGender("Female") 
                .setAgeYears(2)
                .setVaccinated(false)
                .setPassportReady(false)
                .build();
    }
}