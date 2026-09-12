# Builder Pattern - Pet Adoption Shop

## Project Description
This project implements the Builder design pattern for a Pet Adoption Shop. It allows creating detailed pet profiles (Dog, Cat, etc.) step-by-step.

## Clean Code Principles

1. Meaningful Names: Class and field names clearly express their intention (`PetBuilder`, `isVaccinated`).
2. Single Responsibility Methods: Every setter in `PetBuilder` modifies only one property.
3. Validation in build(): `PetBuilder` validates fields before object creation and throws an exception on bad data.
4. No Magic Numbers: Constant `MAX_AGE_LIMIT` is used instead of a raw number `30`.
5. Fluent Interface: Method chaining allows readable construction calls (`builder.setName().setSpecies().build()`).