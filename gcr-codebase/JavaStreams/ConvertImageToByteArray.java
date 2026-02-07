package JavaStreams;
import java.io.*;
public class ConvertImageToByteArray {

	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("cat.jpg");
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			byte[] buffer = new byte[4096];
			int bytesRead;
			while((bytesRead = fis.read(buffer))!=-1) {
				baos.write(buffer,0,bytesRead);
			}
			byte[] imageBytes = baos.toByteArray();
			
			ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
			FileOutputStream fos = new FileOutputStream("outputimg.jpg");
			while((bytesRead=bais.read(buffer))!=-1) {
				fos.write(buffer,0,bytesRead);
			}
			System.out.println("Image converted");
			fis.close();
			fos.close();
		}catch(IOException e) {
			e.getStackTrace();
		}
	}

}
