public interface DocumentRenderer {
    String renderHeader(String title);

    String renderField(String label, String value);

    String renderFooter(String note);
}
