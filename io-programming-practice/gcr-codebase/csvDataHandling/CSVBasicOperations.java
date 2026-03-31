package csvDataHandling;

import java.io.InputStreamReader;
import com.opencsv.CSVReader;

public class CSVBasicOperations {

    public static void main(String[] args) {

        try (
                CSVReader reader = new CSVReader(
                        new InputStreamReader(
                               CSVBasicOperations.class
                                        .getResourceAsStream("student.csv")
                        )
                )
        ) {

            String[] row;

            reader.readNext(); // skip header

            while ((row = reader.readNext()) != null) {

                System.out.println(
                        row[0] + " " +
                        row[1] + " " +
                        row[2] + " " +
                        row[3]
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
