package JavaStreams;
import java.io.*;
public class ConvertUppercaseToLowercase {

	public static void main(String[] args) {
		try {
		FileReader fr = new FileReader("Example.txt");
		BufferedReader br = new BufferedReader(fr);
		
		FileWriter fw = new FileWriter("outputfile.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		
		String line;
		while((line=br.readLine())!=null) {
			String lowcase = line.toLowerCase();
			bw.write(lowcase);
			bw.newLine();
		}
		br.close();
		bw.close();
		System.out.println("Conversion successfull");
		}catch(IOException e) {
			System.out.println("file not found");
		}
	}

}
