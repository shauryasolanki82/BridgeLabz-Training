package csvDataHandling;
import java.io.*;
import java.util.HashSet;

public class CSVDuplicateDetector {

    public static void main(String[] args) {

        HashSet<String> ids = new HashSet<>();

        try (BufferedReader br =
                     new BufferedReader(new FileReader("students.csv"))) {

            br.readLine(); // skip header

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");
                String id = data[0];

                if (!ids.add(id)) {
                    System.out.println("Duplicate Record: " + line);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
