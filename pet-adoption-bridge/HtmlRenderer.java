public class HtmlRenderer implements DocumentRenderer {

    @Override
    public String renderHeader(String title) {
        return "<html>\n<body>\n  <h1>" + escape(title) + "</h1>\n";
    }

    @Override
    public String renderField(String label, String value) {
        return "  <p><b>" + escape(label) + ":</b> " + escape(value) + "</p>\n";
    }

    @Override
    public String renderFooter(String note) {
        String noteBlock = note.isEmpty() ? "" : "  <footer>" + escape(note) + "</footer>\n";
        return noteBlock + "</body>\n</html>\n";
    }

    private String escape(String text) {
        return text.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;");
    }
}
