import java.util.HashSet;
import java.util.Set;

/** Subsystem 2: tracks which animals are free, reserved or adopted. */
public class InventoryService {
    private final Set<String> existingAnimals = new HashSet<>();
    private final Set<String> reservedAnimals = new HashSet<>();
    private final Set<String> adoptedAnimals = new HashSet<>();

    public InventoryService() {
        existingAnimals.add("DOG-1");
        existingAnimals.add("CAT-1");
        existingAnimals.add("CAT-2");
    }

    public void reserve(String animalId) {
        if (!existingAnimals.contains(animalId)) {
            throw new IllegalStateException("No animal with id " + animalId + ".");
        }
        if (adoptedAnimals.contains(animalId)) {
            throw new IllegalStateException(animalId + " is already adopted.");
        }
        if (!reservedAnimals.add(animalId)) {
            throw new IllegalStateException(animalId + " is reserved by someone else.");
        }
        System.out.println("[Inventory] " + animalId + " reserved.");
    }

    public void release(String animalId) {
        if (reservedAnimals.remove(animalId)) {
            System.out.println("[Inventory] Reservation of " + animalId + " released.");
        }
    }

    public void markAdopted(String animalId) {
        reservedAnimals.remove(animalId);
        adoptedAnimals.add(animalId);
        System.out.println("[Inventory] " + animalId + " marked as adopted.");
    }
}
