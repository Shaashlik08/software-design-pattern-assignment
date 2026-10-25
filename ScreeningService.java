public class ScreeningService {
    private static final int MINIMUM_AGE = 18;

    public void screen(String applicantName, int applicantAge) {
        if (applicantName == null || applicantName.trim().isEmpty()) {
            throw new IllegalStateException("Applicant name is required.");
        }
        if (applicantAge < MINIMUM_AGE) {
            throw new IllegalStateException("Applicant must be at least " + MINIMUM_AGE + " years old.");
        }
        System.out.println("[Screening] " + applicantName + " approved.");
    }
}
