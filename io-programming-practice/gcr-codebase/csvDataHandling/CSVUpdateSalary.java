package csvDataHandling;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CSVUpdateSalary {

    public static void main(String[] args) {

        try (
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                CSVUpdateSalary.class
                                        .getResourceAsStream("/csvDataHandling/Employee.csv")
                        )
                )
        ) {

            String line;

            reader.readLine(); // skip header

            while ((line = reader.readLine()) != null) {

                String[] dataStrings = line.split(",");

                double oldSalary = Double.parseDouble(dataStrings[3]);
                double newSalary = oldSalary * 1.10; // 10% hike

                System.out.println(
                        dataStrings[0] + " " +
                        dataStrings[1] + " " +
                        dataStrings[2] + " " +
                        newSalary
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
