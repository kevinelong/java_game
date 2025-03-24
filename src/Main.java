import java.util.Map;

public class Main {

    public static String Attrs(Map<String, String> attrs) {
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String, String> entry : attrs.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            sb.append(" ");
            sb.append(key);
            sb.append("=\"");
            sb.append(value);
            sb.append("\"");
        }

        return sb.toString();
    }
    public static String ClosingTag(String tagName) {
        StringBuilder sb = new StringBuilder("</");
        sb.append(tagName);
        sb.append(">");
        return sb.toString();
    }
    public static String OpeningTag(String tagName, Map<String, String> attrs) {
        StringBuilder sb = new StringBuilder("<");
        sb.append(tagName);
        if(attrs.size() > 0){
            sb.append(Attrs(attrs));
        }
        sb.append(">");
        return sb.toString();
    }
    public static String ClosedTag(String tagName, String content, Map<String, String> attrs) {
        StringBuilder sb = new StringBuilder(OpeningTag(tagName, attrs));
        sb.append(content);
        sb.append(ClosingTag(tagName));
        return sb.toString();
    }

    public static void main(String[] args) {
        // Example usage:
        Map<String, String> attributes = new java.util.HashMap<>();
        attributes.put("id", "myElement");
        attributes.put("class", "highlight");
        attributes.put("name", "inputField");

        String htmlTag = ClosedTag("div", "content", attributes);
        System.out.println(htmlTag);
    }
}