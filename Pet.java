public class Pet {
    private final String name;
    private final String species;
    private final String breed;
    private final String gender; 
    private final int ageYears;
    private final boolean isVaccinated;
    private final boolean isPassportReady;

    Pet(PetBuilder builder) {
        this.name = builder.getName();
        this.species = builder.getSpecies();
        this.breed = builder.getBreed();
        this.gender = builder.getGender(); 
        this.ageYears = builder.getAgeYears();
        this.isVaccinated = builder.isVaccinated();
        this.isPassportReady = builder.isPassportReady();
    }

    public String getName() {
         return name; 
     }
    public String getSpecies() { 
        return species;
     }
    public String getBreed() {
         return breed;
     }
    public String getGender() {
         return gender;
     } 
    public int getAgeYears() {
         return ageYears; 
     }
    public boolean isVaccinated() { 
        return isVaccinated;
     }
    public boolean isPassportReady() {
        return isPassportReady;
     }

    @Override
    public String toString() {
        String breedText = (breed != null && !breed.isEmpty()) ? breed : "Mixed / Unknown";
        String genderText = (gender != null && !gender.isEmpty()) ? gender : "Unknown";

        return "--PET CARD" +
                "\nName: " + name +
                "\nSpecies: " + species +
                "\nBreed: " + breedText +
                "\nGender: " + genderText + 
                "\nAge: " + ageYears + " y.o." +
                "\nVaccinated: " + (isVaccinated ? "Yes" : "No") +
                "\nPassport: " + (isPassportReady ? "Yes" : "No") +
                "\n--";
    }
}