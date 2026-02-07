package JavaStreams;
import java.io.*;
public class ReadandWriteTextFile {
	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("example.txt");
			FileOutputStream fos = new FileOutputStream("outputfile.txt");
			int byteData;
			while((byteData = fis.read()) !=-1) {
				fos.write(byteData);
			}
			System.out.println("File copied successfully");
			fis.close();
			fos.close();
		}catch(IOException e) {
			System.out.println("Source file not found");
		}
	}
}
