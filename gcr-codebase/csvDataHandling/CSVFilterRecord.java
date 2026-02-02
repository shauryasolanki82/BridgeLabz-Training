package csvDataHandling;

import java.io.BufferedReader;
import java.io.FileReader;

public class CSVFilterRecord {
	public static void main(String[] args) {

        try (BufferedReader br =
                     new BufferedReader(new FileReader("students.csv"))) {

            String line;

            br.readLine(); // skip header

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                int marks = Integer.parseInt(data[3]);

                if (marks > 80) {

                    System.out.println(
                            data[0] + " " +
                            data[1] + " " +
                            data[2] + " " +
                            data[3]
                    );
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}