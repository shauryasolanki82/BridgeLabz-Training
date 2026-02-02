package csvDataHandling;

import java.io.*;
import java.util.HashMap;

public class CSVMergeFiles {

    public static void main(String[] args) {

        HashMap<String, String[]> map = new HashMap<>();

        try {

            // ✅ Read students1.csv
            BufferedReader br1 = new BufferedReader(
                    new InputStreamReader(
                            CSVMergeFiles.class.getResourceAsStream("/csvDataHandling/students1.csv")
                    )
            );

            br1.readLine(); // skip header

            String line;

            while ((line = br1.readLine()) != null) {

                String[] data = line.split(",");

                // ID -> Name, Age
                map.put(data[0], new String[]{data[1], data[2]});
            }

            br1.close();


            // ✅ Read students2.csv
            BufferedReader br2 = new BufferedReader(
                    new InputStreamReader(
                            CSVMergeFiles.class.getResourceAsStream("/csvDataHandling/students2.csv")
                    )
            );

            // ✅ Write merged file
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter("merged_students.csv")
            );

            writer.write("ID,Name,Age,Marks,Grade");
            writer.newLine();

            br2.readLine(); // skip header

            while ((line = br2.readLine()) != null) {

                String[] data = line.split(",");

                String id = data[0];

                if (map.containsKey(id)) {

                    String[] studentInfo = map.get(id);

                    writer.write(
                            id + "," +
                            studentInfo[0] + "," +
                            studentInfo[1] + "," +
                            data[1] + "," +
                            data[2]
                    );

                    writer.newLine();
                }
            }

            br2.close();
            writer.close();

            System.out.println("✅ Files merged successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
