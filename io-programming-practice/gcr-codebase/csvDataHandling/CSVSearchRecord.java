package csvDataHandling;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CSVSearchRecord {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try (
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                CSVSearchRecord.class
                                        .getResourceAsStream("/csvDataHandling/student.csv")
                        )
                )
        ) {

            System.out.print("Enter name to search: ");
            String name = sc.next();

            String line;
            reader.readLine(); // skip header

            boolean isfound = false;

            while ((line = reader.readLine()) != null) {

                String[] m = line.split(",");

                if (name.equalsIgnoreCase(m[1])) {
                    isfound = true;

                    System.out.println(
                            m[0] + " " + m[1] + " " + m[2] + " " + m[3]
                    );

                    break;
                }
            }

            
            if (isfound) {
                System.out.println("Name is found");
            } else {
                System.out.println("Not found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        sc.close();
    }
}
