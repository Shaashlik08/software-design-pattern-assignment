import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

public class AdoptionCertificate extends AdoptionDocument {
    private final String petName;
    private final String species;
    private final String adopterName;
    private final LocalDate adoptionDate;

    public AdoptionCertificate(DocumentRenderer renderer, String petName, String species,
                               String adopterName, LocalDate adoptionDate) {
        super(renderer);
        this.petName = requireText(petName, "Pet name");
        this.species = requireText(species, "Species");
        this.adopterName = requireText(adopterName, "Adopter name");
        this.adoptionDate = adoptionDate;
    }

    @Override
    protected String getTitle() {
        return "Adoption Certificate";
    }

    @Override
    protected Map<String, String> getFields() {
        Map<String, String> fields = new LinkedHashMap<>();
        fields.put("Pet", petName);
        fields.put("Species", species);
        fields.put("Adopted by", adopterName);
        fields.put("Date", adoptionDate.toString());
        return fields;
    }

    @Override
    protected String getFooterNote() {
        return "Thank you for giving " + petName + " a home!";
    }
}
