public class AdoptionFacade {
    private static final double ADOPTION_FEE = 50.0;

    private final ScreeningService screeningService = new ScreeningService();
    private final InventoryService inventoryService = new InventoryService();
    private final VeterinaryService veterinaryService = new VeterinaryService();
    private final PaymentService paymentService = new PaymentService();

    public String adoptAnimal(String applicantName, int applicantAge, String animalId) {
        boolean reserved = false;
        try {
            screeningService.screen(applicantName, applicantAge);
            inventoryService.reserve(animalId);
            reserved = true;
            veterinaryService.checkHealth(animalId);
            paymentService.charge(applicantName, ADOPTION_FEE);
            inventoryService.markAdopted(animalId);
            return "SUCCESS: " + applicantName + " adopted " + animalId + ".";
        } catch (IllegalStateException e) {
            if (reserved) {
                inventoryService.release(animalId);
            }
            return "FAILED: " + e.getMessage();
        }
    }
}
