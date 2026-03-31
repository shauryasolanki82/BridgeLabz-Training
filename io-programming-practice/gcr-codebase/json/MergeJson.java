package bridgelabz.json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Iterator;
import java.util.Map;

public class MergeJson {
    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String json1 = "{\"id\": 101, \"name\": \"Alice\", \"role\": \"User\"}";
            String json2 = "{\"role\": \"Admin\", \"email\": \"alice@example.com\", \"city\": \"New York\"}";

            JsonNode node1 = mapper.readTree(json1);
            JsonNode node2 = mapper.readTree(json2);
            ObjectNode merged = (ObjectNode) node1;
            Iterator<Map.Entry<String, JsonNode>> fields = node2.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> field = fields.next();
                merged.set(field.getKey(), field.getValue());
            }
            System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(merged));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}