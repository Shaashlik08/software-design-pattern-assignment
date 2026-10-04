public class PlainTextRenderer implements DocumentRenderer {
    private static final char TITLE_UNDERLINE = '=';

    @Override
    public String renderHeader(String title) {
        return title + "\n" + String.valueOf(TITLE_UNDERLINE).repeat(title.length()) + "\n";
    }

    @Override
    public String renderField(String label, String value) {
        return label + ": " + value + "\n";
    }

    @Override
    public String renderFooter(String note) {
        return note.isEmpty() ? "" : "\n" + note + "\n";
    }
}
