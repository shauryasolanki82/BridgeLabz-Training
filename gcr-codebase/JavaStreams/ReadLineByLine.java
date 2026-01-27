package JavaStreams;
import java.io.*;
public class ReadLineByLine {

	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader("example.txt");
			BufferedReader br = new BufferedReader(fr);
			String line;
			while((line=br.readLine())!=null) {
				if(line.toLowerCase().contains("error")) System.out.println(line);
			}
			br.close();
		}catch(IOException e) {
			System.out.println("file not found");
		}
	}

}
