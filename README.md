Pet Adoption System (Builder, Factory Method, Abstract Factory)
Description

A small Java console app for building and issuing pet adoption profiles. It's split into three parts, one per creational pattern:

Builder — constructs a Pet. A Pet has 7 fields, some required (name, species) and some optional (breed, gender, vaccination, passport). A single 7-parameter constructor would either be easy to mix up or force every field to be filled at once. The builder lets fields be set one at a time, and the object is only created after build() checks that it's valid.
Factory Method — decides which kind of pet to build. PetFactory defines the algorithm for registering a pet (registerPet()) while leaving the actual creation (createPet()) to subclasses DogFactory and CatFactory, each of which fills in a builder differently.
Abstract Factory — produces a whole family of related adoption-kit objects (pet + food + toy) that are guaranteed to match. AdoptionKitFactory is implemented by DogAdoptionKitFactory and CatAdoptionKitFactory, so client code never has to know or check which species it's working with.
Why each pattern fits this domain

Builder. In real shelter work, a pet's profile isn't filled out in one go — you might register the name and species first and add the vaccination record later, once the vet checks the animal. Not every pet has the same amount of info (a stray usually has no breed or vaccination data, an owned pet usually does), so forcing everything through one constructor doesn't match how this data actually gets collected.

Factory Method. Registering a dog and registering a cat follow the same procedure (build a profile, print a confirmation) but need different defaults (breed, typical age, vaccination status). Factory Method keeps that shared procedure in one place (PetFactory.registerPet()) while letting each subclass own only what's species-specific, so adding a new species later means adding one new factory class, not touching existing ones.

Abstract Factory. An adoption isn't just a pet — the shelter also hands over food and a starter toy, and those have to match the species (you don't send a dog home with catnip). Abstract Factory guarantees that whichever factory is chosen produces a consistent pet + food + toy set, without the client code ever branching on species with if/switch.

Project Structure
Pet.java — immutable domain object, only responsible for holding and printing data
PetBuilder.java — accumulates field values and validates them in build()
PetFactory.java / DogFactory.java / CatFactory.java — Factory Method: shared registration flow, species-specific creation
PetFood.java, PetToy.java and their Dog*/Cat* implementations — the product families used by the Abstract Factory
AdoptionKitFactory.java / DogAdoptionKitFactory.java / CatAdoptionKitFactory.java — Abstract Factory: produces a matching pet + food + toy set
Main.java — entry point; demonstrates manual building, Factory Method, Abstract Factory, and the validation failure path
Clean Code Principles Applied
1. Meaningful, intention-revealing names

Fields, methods, and classes say exactly what they hold or do, so no comment is needed to explain them.

Before: boolean v;
After: private boolean isVaccinated; The getter isVaccinated() follows the standard boolean-accessor convention, so calling code reads like a sentence (if (pet.isVaccinated())). The same applies to AdoptionKitFactory.createFood() / createToy() — the name alone tells you what you get back, no need to inspect the implementation.
2. Small methods, single responsibility

Every setter in PetBuilder touches exactly one field and does nothing else — no validation, no side effects — so each method fits on one line and is trivial to review.

java
public PetBuilder setBreed(String breed) {
    this.breed = breed;
    return this;
}

Validation logic is deliberately kept out of the setters and centralized in build() instead, so a setter can never throw and a reader always knows where correctness is enforced. Likewise, each create*() method in the factories does exactly one thing: build one object and return it.

3. Small, focused classes (single responsibility per class)

Each class answers to one reason to change:

Pet only stores and displays data — it has no knowledge of how it was validated or constructed.
PetBuilder only accumulates state and validates it — it doesn't know what a "standard puppy" is.
DogFactory / CatFactory only know one species' defaults — they don't know how to register a pet in general.
PetFactory only knows the shared registration procedure — it doesn't know any species' specific defaults.
DogAdoptionKitFactory / CatAdoptionKitFactory only know how to assemble one species' kit — they don't know how a Pet is validated or how a kit is used.

This separation means a change to validation rules (e.g., raising MAX_AGE_LIMIT) never touches the factories, and adding a new species (e.g., RabbitFactory + RabbitAdoptionKitFactory) never touches PetBuilder or any existing factory.

4. Validated construction

build() refuses to hand back a Pet that is missing required data or has a nonsensical age, catching mistakes at the earliest possible point instead of letting an invalid object leak into the rest of the program.

java
public Pet build() {
    if (name == null || name.trim().isEmpty()) {
        throw new IllegalStateException("Pet name cannot be empty!");
    }
    if (ageYears < 0 || ageYears > MAX_AGE_LIMIT) {
        throw new IllegalStateException("Invalid pet age: " + ageYears);
    }
    return new Pet(this);
}

Main.java demonstrates this directly: building a pet with ageYears = -5 throws and is caught, rather than silently producing a broken Pet.

5. No magic numbers

The only domain-specific numeric threshold in the logic — the upper age bound — is named instead of left as a bare literal, so its meaning and its single point of change are obvious.

Before: if (ageYears > 30)
After: private static final int MAX_AGE_LIMIT = 30; used in build()

Note: the 0 lower bound in the same check is a universal non-negativity constraint, not a domain-specific value, so it's left as a literal — extracting it into a constant would add noise without adding meaning.

6. Program to an interface, not an implementation

Main and prepareStarterKit() depend only on the abstractions PetFactory and AdoptionKitFactory, never on DogFactory/CatFactory/DogAdoptionKitFactory/CatAdoptionKitFactory directly. This is what makes it possible to swap which concrete factory is used without changing any client code — a direct consequence of applying Factory Method and Abstract Factory correctly, not just a naming exercise.

