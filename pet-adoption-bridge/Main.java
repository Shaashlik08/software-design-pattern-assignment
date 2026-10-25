import java.time.LocalDate;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        DocumentRenderer plainText = new PlainTextRenderer();
        DocumentRenderer html = new HtmlRenderer();

        System.out.println("=== 1. One abstraction, switching implementors at runtime ===");
        AdoptionDocument certificate = new AdoptionCertificate(
                plainText, "Aktos", "Dog", "Aigerim", LocalDate.of(2026, 10, 4));
        System.out.println("--- Plain text ---");
        System.out.println(certificate.render());

        certificate.setRenderer(html);
        System.out.println("--- HTML ---");
        System.out.println(certificate.render());

        System.out.println("=== 2. Another abstraction, same implementors ===");
        AdoptionDocument report = new VaccinationReport(
                plainText, "Tom & Jerry", Arrays.asList("Rabies", "Distemper"),
                "Dr. Nurlan", LocalDate.of(2026, 9, 20));
        System.out.println("--- Plain text ---");
        System.out.println(report.render());

        report.setRenderer(html);
        System.out.println("--- HTML (special characters are escaped) ---");
        System.out.println(report.render());

        System.out.println("=== 3. Validation failures ===");
        try {
            new AdoptionCertificate(plainText, "  ", "Cat", "Aigerim", LocalDate.now());
        } catch (IllegalArgumentException e) {
            System.out.println("Caught: " + e.getMessage());
        }
        try {
            certificate.setRenderer(null);
        } catch (NullPointerException e) {
            System.out.println("Caught: " + e.getMessage());
        }
    }
}
