package bridgelabz.json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.Iterator;
import java.util.Map;

public class PrintAllKeys {
    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(new File("data3.json"));
            printKeysAndValues(rootNode, "");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printKeysAndValues(JsonNode node, String prefix) {
        if (node.isObject()) {
            Iterator<Map.Entry<String, JsonNode>> fields = node.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> field = fields.next();
                String key = field.getKey();
                JsonNode value = field.getValue();
                if (value.isContainerNode()) {
                    System.out.println(prefix + key + ":");
                    printKeysAndValues(value, prefix + "  ");
                } else {
                    System.out.println(prefix + key + " : " + value.asText());
                }
            }
        } 
        else if (node.isArray()) {
            for (int i = 0; i < node.size(); i++) {
                System.out.println(prefix + "[" + i + "]");
                printKeysAndValues(node.get(i), prefix + "  ");
            }
        }
    }
}