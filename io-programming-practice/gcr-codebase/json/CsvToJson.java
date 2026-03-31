package bridgelabz.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.File;
import java.util.List;
import java.util.Map;

public class CsvToJson {
    public static void main(String[] args) {
        try {
            File inputCsv = new File("data.csv");
            File outputJson = new File("csvtojson.json");
            CsvMapper csvMapper = new CsvMapper();
            CsvSchema schema = CsvSchema.emptySchema().withHeader();
            List<Object> data = csvMapper.readerFor(Map.class)
                    .with(schema)
                    .readValues(inputCsv)
                    .readAll();
            ObjectMapper jsonMapper = new ObjectMapper();
            jsonMapper.writerWithDefaultPrettyPrinter().writeValue(outputJson, data);
            System.out.println(jsonMapper.writerWithDefaultPrettyPrinter().writeValueAsString(data));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}