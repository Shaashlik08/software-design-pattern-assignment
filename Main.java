/** Client: uses only the AdoptionFacade. */
public class Main {
    public static void main(String[] args) {
        AdoptionFacade adoption = new AdoptionFacade();

        System.out.println("=== 1. Successful adoption ===");
        System.out.println(adoption.adoptAnimal("Aibek", 25, "DOG-1"));

        System.out.println("\n=== 2. Applicant too young ===");
        System.out.println(adoption.adoptAnimal("Timur", 16, "CAT-1"));

        System.out.println("\n=== 3. Animal already adopted ===");
        System.out.println(adoption.adoptAnimal("Dana", 30, "DOG-1"));

        System.out.println("\n=== 4. Sick animal (reservation is released) ===");
        System.out.println(adoption.adoptAnimal("Madina", 28, "CAT-2"));
    }
}
