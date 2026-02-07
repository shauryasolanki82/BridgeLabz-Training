package JavaStreams;
import java.io.*;
public class UserInputFromConsole {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			FileWriter fw = new FileWriter("UserData.txt");
			System.out.print("Enter your name: ");
			String name = br.readLine();
			System.out.print("Enter your age: ");
			String age = br.readLine();
			System.out.print("Enter your fav programmming language: ");
			String lang = br.readLine();
			fw.write("User data\n");
			fw.write("Name: "+name+", Age: "+age+", Favourite programming language: "+lang);
			
			System.out.println();
			System.out.println("User data saved successfully");
			fw.close();
		}catch(IOException e) {
			System.out.println("Error occurred");
		}
	}

}
