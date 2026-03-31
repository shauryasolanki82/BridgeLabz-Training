package JavaStreams;
import java.io.*;

public class BufferedStreamsFileCopy {

    private static final int BUFFER_SIZE = 4096;

    // 🔹 Unbuffered file copy
    public static void copyUsingFileStreams(String src, String dest) throws IOException {
        FileInputStream fis = new FileInputStream(src);
        FileOutputStream fos = new FileOutputStream(dest);

        byte[] buffer = new byte[BUFFER_SIZE];
        int bytesRead;

        while ((bytesRead = fis.read(buffer)) != -1) {
            fos.write(buffer, 0, bytesRead);
        }

        fis.close();
        fos.close();
    }

    // 🔹 Buffered file copy
    public static void copyUsingBufferedStreams(String src, String dest) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest));

        byte[] buffer = new byte[BUFFER_SIZE];
        int bytesRead;

        while ((bytesRead = bis.read(buffer)) != -1) {
            bos.write(buffer, 0, bytesRead);
        }

        bis.close();
        bos.close();
    }

    public static void main(String[] args) {

        String sourceFile = "example.txt";     // e.g., 100MB file
        String unbufferedDest = "outputfile.txt";
        String bufferedDest = "outputfile2.txt";

        try {
            // 🔸 Measure unbuffered time
            long start1 = System.nanoTime();
            copyUsingFileStreams(sourceFile, unbufferedDest);
            long end1 = System.nanoTime();

            long unbufferedTime = end1 - start1;

            // 🔸 Measure buffered time
            long start2 = System.nanoTime();
            copyUsingBufferedStreams(sourceFile, bufferedDest);
            long end2 = System.nanoTime();

            long bufferedTime = end2 - start2;

            // 🔸 Results
            System.out.println("Unbuffered Copy Time (ns): " + unbufferedTime);
            System.out.println("Buffered Copy Time (ns):   " + bufferedTime);

        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }
}
