public class PetBuilder {
    private static final int MAX_AGE_LIMIT = 30;

    private String name;
    private String species;
    private String breed;
    private String gender; 
    private int ageYears;
    private boolean isVaccinated = false;
    private boolean isPassportReady = false;

    public PetBuilder() {}

    public PetBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PetBuilder setSpecies(String species) {
        this.species = species;
        return this;
    }

    public PetBuilder setBreed(String breed) {
        this.breed = breed;
        return this;
    }

    public PetBuilder setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public PetBuilder setAgeYears(int ageYears) {
        this.ageYears = ageYears;
        return this;
    }

    public PetBuilder setVaccinated(boolean isVaccinated) {
        this.isVaccinated = isVaccinated;
        return this;
    }

    public PetBuilder setPassportReady(boolean isPassportReady) {
        this.isPassportReady = isPassportReady;
        return this;
    }

    public String getName() { return name; }
    public String getSpecies() { return species; }
    public String getBreed() { return breed; }
    public String getGender() { return gender; } 
    public int getAgeYears() { return ageYears; }
    public boolean isVaccinated() { return isVaccinated; }
    public boolean isPassportReady() { return isPassportReady; }

    public Pet build() {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalStateException("Pet name cannot be empty!");
        }
        if (species == null || species.trim().isEmpty()) {
            throw new IllegalStateException("Pet species is required!");
        }
        if (ageYears < 0 || ageYears > MAX_AGE_LIMIT) {
            throw new IllegalStateException("Invalid pet age: " + ageYears);
        }

        return new Pet(this);
    }
}