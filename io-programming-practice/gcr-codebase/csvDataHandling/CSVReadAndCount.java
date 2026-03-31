package csvDataHandling;

import java.io.BufferedReader;

public class CSVReadAndCount {
	  public static void main(String[] args) {

	        int count = 0;

	        try (BufferedReader br =
	                     new BufferedReader(new FileReader("Employee.csv"))) {

	            br.readLine(); // skip header

	            while (br.readLine() != null) {
	                count++;
	            }

	            System.out.println("Total Records: " + count);

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}