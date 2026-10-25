import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class VaccinationReport extends AdoptionDocument {
    private final String petName;
    private final List<String> vaccines;
    private final String veterinarian;
    private final LocalDate checkDate;

    public VaccinationReport(DocumentRenderer renderer, String petName, List<String> vaccines,
                             String veterinarian, LocalDate checkDate) {
        super(renderer);
        this.petName = requireText(petName, "Pet name");
        this.veterinarian = requireText(veterinarian, "Veterinarian");
        if (vaccines == null || vaccines.isEmpty()) {
            throw new IllegalArgumentException("Vaccine list cannot be empty!");
        }
        this.vaccines = new ArrayList<>(vaccines);
        this.checkDate = checkDate;
    }

    @Override
    protected String getTitle() {
        return "Vaccination Report";
    }

    @Override
    protected Map<String, String> getFields() {
        Map<String, String> fields = new LinkedHashMap<>();
        fields.put("Pet", petName);
        fields.put("Vaccines", String.join(", ", vaccines));
        fields.put("Veterinarian", veterinarian);
        fields.put("Checked on", checkDate.toString());
        return fields;
    }
}
