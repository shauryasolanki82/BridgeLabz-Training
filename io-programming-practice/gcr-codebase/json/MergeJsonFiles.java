package bridgelabz.json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;
import java.util.Iterator;
import java.util.Map;

public class MergeJsonFiles {
    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode1 = mapper.readTree(new File("file1.json"));
            JsonNode rootNode2 = mapper.readTree(new File("file2.json"));
            ObjectNode mergedNode = (ObjectNode) rootNode1;
            Iterator<Map.Entry<String, JsonNode>> fields = rootNode2.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> field = fields.next();
                mergedNode.set(field.getKey(), field.getValue());
            }
            System.out.println("Merged JSON:");
            System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(mergedNode));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}