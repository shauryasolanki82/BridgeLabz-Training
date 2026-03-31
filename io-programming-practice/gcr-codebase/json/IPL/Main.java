package bridgelabz.json.IPL;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        try {
        	System.out.println("Processing JSON...");
            String inputJson = "ipl_data.json";
            String outputJson = "ipl_data_censored.json";
            
            List<IplMatch> jsonMatches = FileHandler.readJson(inputJson);
            List<IplMatch> censoredJsonMatches = jsonMatches.stream()
                    .map(CensorService::censorMatch)
                    .collect(Collectors.toList());
            FileHandler.writeJson(outputJson, censoredJsonMatches);
            
            System.out.println("\nProcessing CSV...");
            String inputCsv = "ipl_data.csv";
            String outputCsv = "ipl_data_censored.csv";
            List<IplMatch> csvMatches = FileHandler.readCsv(inputCsv);
            List<IplMatch> censoredCsvMatches = csvMatches.stream()
                    .map(CensorService::censorMatch)
                    .collect(Collectors.toList());
            FileHandler.writeCsv(outputCsv, censoredCsvMatches);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
