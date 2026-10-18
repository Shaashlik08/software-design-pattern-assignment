/** Subsystem 4: charges the adoption fee. */
public class PaymentService {
    private static final double CARD_LIMIT = 100.0;

    public void charge(String applicantName, double amount) {
        if (amount > CARD_LIMIT) {
            throw new IllegalStateException("Payment of " + amount + " exceeds the limit.");
        }
        System.out.println("[Payment] " + applicantName + " paid " + amount + ".");
    }
}
