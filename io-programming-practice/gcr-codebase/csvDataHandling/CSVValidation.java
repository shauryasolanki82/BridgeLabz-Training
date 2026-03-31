package csvDataHandling;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CSVValidation {
public static void main(String[] args) {
	try {
		BufferedReader bf=new BufferedReader(new InputStreamReader(CSVValidation.class .getResourceAsStream("/csvDataHandling/Employee.csv")));
		
		String lineString;
		
		bf.readLine();
		//email 
		String matchString = "^[a-zA-Z0-9._%+-]+@gmail\\.com$";
		String matchPhoneString = "^[6-9][0-9]{9}$";

		
		while((lineString=bf.readLine())!=null) {
			String [] l=lineString.split(",");
			
			String mailString=l[2];
			String phoneString=l[3];
			
			if(mailString.matches(matchString) && phoneString.matches(matchPhoneString)) {
			
				System.out.println(l[0]+" "
						+l[1]+" "
						+l[2]+" "
						+l[3]+" ");
			}else {
				System.out.println("Invalid.......");
			}
			
			
		}
		
	}catch (Exception e) {
		e.printStackTrace();
	}
}
}
