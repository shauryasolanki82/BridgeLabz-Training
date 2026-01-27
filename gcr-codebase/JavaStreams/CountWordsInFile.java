package JavaStreams;
import java.io.*;
import java.util.*;
public class CountWordsInFile {

	public static void main(String[] args) {
		Map<String,Integer> wordCount = new HashMap<>();
		int totalWords=0;
		try {
			FileReader fr = new FileReader("example.txt");
			BufferedReader br = new BufferedReader(fr);
			
			String line;
			while((line=br.readLine())!=null) {
				line = line.toLowerCase().replaceAll("[^a-z ]", "");
				String[] words = line.split("\\s+");
				for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                        totalWords++;
                    }
                }
			}
			
			br.close();
		}catch(IOException e) {
			System.out.println("file not found");
		}

		List<Map.Entry<String, Integer>> list =new ArrayList<>(wordCount.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue());
        System.out.println("Total words in file: " + totalWords);
        System.out.println("Top 5 most frequent words:");
        for (int i = 0; i < Math.min(5, list.size()); i++) {
            System.out.println(list.get(i).getKey() + " : " + list.get(i).getValue());
        }
	}

}
