import java.util.Map;
import java.util.Objects;

public abstract class AdoptionDocument {
    private DocumentRenderer renderer;

    protected AdoptionDocument(DocumentRenderer renderer) {
        this.renderer = requireRenderer(renderer);
    }

    public void setRenderer(DocumentRenderer renderer) {
        this.renderer = requireRenderer(renderer);
    }

    private static DocumentRenderer requireRenderer(DocumentRenderer renderer) {
        return Objects.requireNonNull(renderer, "Renderer cannot be null!");
    }

    public final String render() {
        StringBuilder result = new StringBuilder(renderer.renderHeader(getTitle()));
        for (Map.Entry<String, String> field : getFields().entrySet()) {
            result.append(renderer.renderField(field.getKey(), field.getValue()));
        }
        result.append(renderer.renderFooter(getFooterNote()));
        return result.toString();
    }

    protected abstract String getTitle();

    protected abstract Map<String, String> getFields();

    protected String getFooterNote() {
        return "";
    }

    protected static String requireText(String value, String fieldName) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(fieldName + " cannot be empty!");
        }
        return value;
    }
}
