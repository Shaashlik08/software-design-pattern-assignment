# Pet Adoption System (Builder Pattern)

## Description
A simple Java application for creating pet adoption profiles with step-by-step validated construction.


## Project Structure
* Pet.java — Main domain class (immutable)
* PetBuilder.java — Builder with validation rules
* PetDirector.java — Director with predefined recipes
* Main.java — Entry point with tests and exception handling



## Clean Code Principles Applied

### 1. Meaningful Names
Self-explanatory variable names.
* Before: `boolean v;`
* After: `private boolean isVaccinated;`

### 2. Small Methods
Each builder setter modifies exactly one field.
public PetBuilder setBreed(String breed) {
    this.breed = breed;
    return this;
}


### 3. Small, Focused Classes
Each class has one responsibility: `Pet` only stores/prints data, `PetBuilder` only builds, `PetDirector` only holds recipes — no mixed logic.

### 4. Validated Construction
Prevents creating invalid instances in `build()`.
public Pet build() {
    if (name == null || name.trim().isEmpty()) {
        throw new IllegalStateException("Pet name cannot be empty!");
    }
    if (ageYears < 0 || ageYears > MAX_AGE_LIMIT) {
        throw new IllegalStateException("Invalid pet age: " + ageYears);
    }
    return new Pet(this);
}


### 5. No Magic Numbers
Extracted raw values into constants.
* Before: `if (ageYears > 30)`
* After: `private static final int MAX_AGE_LIMIT = 30;`