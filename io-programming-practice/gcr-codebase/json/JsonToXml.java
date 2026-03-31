package bridgelabz.json;

import org.json.JSONObject;
import org.json.XML;

public class JsonToXml {
    public static void main(String[] args) {
        String jsonString = "{" +
                "\"student\": {" +
                "  \"name\": \"Alice\"," +
                "  \"age\": 22," +
                "  \"subjects\": [\"Math\", \"Science\"]" +
                "}" +
                "}";
        JSONObject json = new JSONObject(jsonString);
        String xml = XML.toString(json);
        System.out.println(xml);
    }
}
