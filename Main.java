public class Main {
    public static void main(String[] args) {
        System.out.println("Pet Adoption Test\n");

        PetBuilder b1 = new PetBuilder();
        b1.setName("Korolevskayasobaka");
        b1.setSpecies("Dog");
        b1.setBreed("Corgi");
        b1.setGender("Male");
        b1.setAgeYears(2);
        b1.setVaccinated(true);
        b1.setPassportReady(true);

        Pet pet1 = b1.build();
        System.out.println(pet1);

        PetDirector director = new PetDirector();

        Pet puppy = director.makeStandardPuppy(new PetBuilder());
        System.out.println(puppy);

        Pet kitten = director.makeStrayKitten(new PetBuilder());
        System.out.println(kitten);

        try {
            PetBuilder badBuilder = new PetBuilder();
            badBuilder.setName("Ghost");
            badBuilder.setSpecies("Dog");
            badBuilder.setAgeYears(-5); // Ошибка
            
            Pet badPet = badBuilder.build();
            System.out.println(badPet);
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}