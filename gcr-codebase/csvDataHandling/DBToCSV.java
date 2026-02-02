package csvDataHandling;
import java.io.FileWriter;
import java.sql.*;

public class DBToCSV {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/company";
        String user = "root";
        String pass = "password";

        try (
                Connection con = DriverManager.getConnection(url, user, pass);
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(
                        "SELECT id,name,department,salary FROM employee"
                );
                FileWriter writer = new FileWriter("employees.csv")
        ) {

            writer.append("Employee ID,Name,Department,Salary\n");

            while (rs.next()) {

                writer.append(
                        rs.getInt("id") + "," +
                        rs.getString("name") + "," +
                        rs.getString("department") + "," +
                        rs.getDouble("salary") + "\n"
                );
            }

            System.out.println("CSV Generated!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
