import java.io.*;

public class LargeCSVReader {

    public static void main(String[] args) {

        int chunkSize = 100;
        int count = 0;

        try (BufferedReader br =
                     new BufferedReader(new FileReader("largefile.csv"))) {

            br.readLine(); // skip header

            String line;

            while ((line = br.readLine()) != null) {

                count++;

                if (count % chunkSize == 0) {
                    System.out.println("Processed: " + count + " records");
                }
            }

            System.out.println("Total Records: " + count);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
