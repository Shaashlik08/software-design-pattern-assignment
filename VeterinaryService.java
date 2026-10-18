import java.util.HashSet;
import java.util.Set;
public class VeterinaryService {
    private final Set<String> sickAnimals = new HashSet<>();

    public VeterinaryService() {
        sickAnimals.add("CAT-2");
    }

    public void checkHealth(String animalId) {
        if (sickAnimals.contains(animalId)) {
            throw new IllegalStateException(animalId + " is not healthy enough for adoption.");
        }
        System.out.println("[Vet] " + animalId + " is healthy.");
    }
}
